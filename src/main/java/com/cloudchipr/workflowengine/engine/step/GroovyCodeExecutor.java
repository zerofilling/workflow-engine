package com.cloudchipr.workflowengine.engine.step;

import com.cloudchipr.workflowengine.engine.context.StepContext;

import java.util.Map;


@StepProcessor(name = "groovy_code")
public class GroovyCodeExecutor implements IStepExecutor {
    @Override
    public Map<String, String> execute(StepContext context) {
        String code = context.configParams().get("groovy_code");
        Map<String, String> params = context.params();
        // convert params to json;
        return executeGroovyCode(code, params);
    }

    private Map<String, String> executeGroovyCode(String code, Map<String, String> params) {
        //todo implement
        return null;
    }
}
