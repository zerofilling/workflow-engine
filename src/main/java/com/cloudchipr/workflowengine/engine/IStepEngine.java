package com.cloudchipr.workflowengine.engine;

import com.cloudchipr.workflowengine.engine.context.StepContext;

public interface IStepEngine {
    void execute(StepContext context);

}
