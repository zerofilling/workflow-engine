package com.cloudchipr.workflowengine.factory;

import com.cloudchipr.workflowengine.dto.ProcessStepDto;
import com.cloudchipr.workflowengine.engine.context.DefaultStepContext;
import com.cloudchipr.workflowengine.engine.context.StepContext;

public class ContextFactoryImpl implements ContextFactoryMethod {
    @Override
    public StepContext getStepContext(ProcessStepDto step) {
        return new DefaultStepContext(step);
    }
}
