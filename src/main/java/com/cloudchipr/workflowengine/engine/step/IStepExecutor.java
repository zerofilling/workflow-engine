package com.cloudchipr.workflowengine.engine.step;

import com.cloudchipr.workflowengine.engine.context.StepContext;

import java.util.Map;

public interface IStepExecutor {
    Map<String, String> execute(StepContext context);

}
