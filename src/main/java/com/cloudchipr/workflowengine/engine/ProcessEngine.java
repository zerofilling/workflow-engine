package com.cloudchipr.workflowengine.engine;

import com.cloudchipr.workflowengine.dao.ProcessStepDao;
import com.cloudchipr.workflowengine.dto.*;
import com.cloudchipr.workflowengine.engine.candidate.ICandidateExecutor;
import com.cloudchipr.workflowengine.engine.context.StepContext;
import com.cloudchipr.workflowengine.engine.step.GroovyCodeExecutor;
import com.cloudchipr.workflowengine.engine.step.IStepExecutor;
import com.cloudchipr.workflowengine.factory.ContextFactoryMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProcessEngine {

    private final ContextFactoryMethod contextFactoryMethod;
    private final ProcessStepDao processStepDao;
    private final StepsQueue stepsQueue;
    private ProcessEngine processEngine;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void executeFlow(ProcessStepDto step) {
        executeFlow(step, true);
    }

    private void executeFlow(ProcessStepDto step, boolean forceExecution) {
        ProcessStepConfig config = step.getConfig();
        IStepExecutor executor = findExecutor(step.getExecutor());
        StepContext stepContext = contextFactoryMethod.getStepContext(step);
        if(Objects.equals(config.getStepExecutionType(), StepExecutionType.SYNC)) {
            if(forceExecution || Objects.equals(config.getStepType(), StepType.AUTO)) {
                Map<String, String> newParams = executor.execute(stepContext);
                processStepDao.saveParams(step.getId(), step.getParams());
                Optional<ProcessStepDto> nextStep = getNextStep(stepContext, newParams);
                nextStep.ifPresent(it->executeFlow(it, false));
            }
        } else {
            stepsQueue.addStepIntoQueue(step);
        }
    }

    @SuppressWarnings("all")
    private Optional<ProcessStepDto> getNextStep(StepContext context, Map<String, String> newParams) {
        ProcessStepDto step = context.step();
        List<WorkflowStepCandidateDto> candidates = step.getCandidates();

        Stream<WorkflowStepCandidateDto> matchingCandidates = candidates.stream()
                .filter(it -> executeCandidateExecutor(context, it.getExecutor()));
        long count = matchingCandidates.count();
        if (count == 0) {
            return Optional.empty();
        } else if (count > 1) {
            throw new RuntimeException("More than one step candidate matches ");
        } else {
            Optional<ProcessStepDto> nextStep = (Optional<ProcessStepDto>) matchingCandidates
                    .map(WorkflowStepCandidateDto::getStep)
                    .map(it->it.toBuilder().params(newParams).build())
            .findAny();
            return nextStep;
        }
    }

    private boolean executeCandidateExecutor(StepContext context, String executor) {
        if(StringUtils.isBlank(executor)) {
            return true;
        }
        ICandidateExecutor candidateExecutor = findCandidateExecutor(executor);
        return candidateExecutor.execute(context);
    }

    private ICandidateExecutor findCandidateExecutor(String executor) {
        // todo find ICandidateExecutor implementation spring bean bean annotated with @StepCandidateExecutor with name $executor
        // return singleton bean of this class from spring container
        return null;
    }

    private IStepExecutor findExecutor(String executor) {
        // todo find IStepExecutor implementation spring bean annotated with @StepProcessor with name $executor
        // return singleton bean of this class from spring container
        return new GroovyCodeExecutor();
    }

    @Autowired
    @Lazy
    public void setProcessEngine(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }
}
