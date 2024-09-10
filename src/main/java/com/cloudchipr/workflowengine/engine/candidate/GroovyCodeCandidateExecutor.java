package com.cloudchipr.workflowengine.engine.candidate;

import com.cloudchipr.workflowengine.engine.context.StepContext;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@CandidateExecutor(name = "groovy_code")
public class GroovyCodeCandidateExecutor implements ICandidateExecutor {
    @Override
    public boolean execute(StepContext context) {
        String code = context.configParams().get("groovy_code");
        Map<String, String> params = context.params();
        // convert params to json;
        return executeGroovyCode(code, params);
    }

    private boolean executeGroovyCode(String code, Map<String, String> params) {
        //todo implement
        return false;
    }
}
