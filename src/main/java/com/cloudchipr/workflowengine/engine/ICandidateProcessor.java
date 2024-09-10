package com.cloudchipr.workflowengine.engine;

import com.cloudchipr.workflowengine.engine.context.StepContext;

public interface ICandidateProcessor {
    boolean execute(StepContext context);

}
