package com.cloudchipr.workflowengine.engine.step;

import com.cloudchipr.workflowengine.engine.context.StepContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@StepExecutor(name = "groovy_code")
public class GroovyCodeExecutor extends OneCandidateExecutor {
    @Override
    public void validate(StepContext context) {
        String code = context.configParams().get("groovy_code");
        // validate groovy code
    }

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
