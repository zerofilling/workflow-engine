package com.cloudchipr.workflowengine.engine;

import com.cloudchipr.workflowengine.engine.context.StepContext;

public interface IStepProcessor {
    void execute(StepContext context);

}
