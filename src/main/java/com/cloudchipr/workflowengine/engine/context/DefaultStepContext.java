package com.cloudchipr.workflowengine.engine.context;

import com.cloudchipr.workflowengine.dto.ProcessStepDto;

import java.util.Map;

public class DefaultStepContext implements StepContext {

    private final ProcessStepDto step;

    public DefaultStepContext(ProcessStepDto step) {
        this.step = step;
    }

    @Override
    public ProcessStepDto step() {
        return this.step;
    }

    @Override
    public Map<String, String> params() {
        return step.getParams();
    }
}
