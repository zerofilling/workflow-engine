package com.cloudchipr.workflowengine.engine.step;

import com.cloudchipr.workflowengine.engine.context.StepContext;

import java.util.Map;

public abstract class ValidatedExecutor implements IStepExecutor {

    @Override
    public Map<String, String> execute(StepContext context) {
        validate(context);
        return run(context);
    }

    protected abstract Map<String, String> run(StepContext context);
    protected abstract void validate(StepContext context);
}
