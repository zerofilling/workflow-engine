package com.cloudchipr.workflowengine.engine.step;

import com.cloudchipr.workflowengine.dto.ProcessStepDto;
import com.cloudchipr.workflowengine.dto.WorkflowStepCandidateDto;
import com.cloudchipr.workflowengine.engine.context.StepContext;
import org.springframework.util.CollectionUtils;

import java.util.List;

public abstract class OneCandidateExecutor extends ValidatedExecutor {
    @Override
    public void validate(StepContext context) {
        ProcessStepDto step = context.step();
        List<WorkflowStepCandidateDto> candidates = step.getCandidates();
        if(!CollectionUtils.isEmpty(candidates) && candidates.size() > 1) {
            throw new RuntimeException("More than one candidate found in stepId %s".formatted(step.getId()));
        }
    }
}
