package com.cloudchipr.workflowengine.factory;

import com.cloudchipr.workflowengine.dto.ProcessStepDto;
import com.cloudchipr.workflowengine.engine.context.StepContext;

public interface ContextFactoryMethod {
    StepContext getStepContext(ProcessStepDto step);
}
