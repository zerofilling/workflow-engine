package com.cloudchipr.workflowengine.engine.step;

import com.cloudchipr.workflowengine.engine.context.StepContext;

import java.util.Map;

public interface IStepExecutor {
    default Map<String, String> validateAndExecute(StepContext context) {
        validate(context);
        return execute(context);
    }
    void validate(StepContext context);
    Map<String, String> execute(StepContext context);

}
