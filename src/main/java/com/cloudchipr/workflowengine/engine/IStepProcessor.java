package com.cloudchipr.workflowengine.engine;

import com.cloudchipr.workflowengine.engine.context.StepContext;

import java.util.Map;

public interface IStepProcessor {
    Map<String, String> execute(StepContext context);

}
