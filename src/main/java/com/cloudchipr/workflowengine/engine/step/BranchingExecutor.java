package com.cloudchipr.workflowengine.engine.step;

import com.cloudchipr.workflowengine.dto.ProcessStepDto;
import com.cloudchipr.workflowengine.engine.context.StepContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Map;

@Component
@StepExecutor(name = "branching_executor")
public class BranchingExecutor implements IStepExecutor {
    @Override
    public void validate(StepContext context) {
        ProcessStepDto step = context.step();
        if(CollectionUtils.isEmpty(step.getCandidates())) {
            throw new RuntimeException("No candidates found for stepId: '%s'".formatted(step.getId()));
        }
    }

    @Override
    public Map<String, String> execute(StepContext context) {
        return context.params();
    }

}
