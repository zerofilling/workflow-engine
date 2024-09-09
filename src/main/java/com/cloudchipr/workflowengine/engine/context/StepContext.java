package com.cloudchipr.workflowengine.engine.context;

import com.cloudchipr.workflowengine.dto.ProcessStepDto;

import java.util.Map;

public interface StepContext {
    ProcessStepDto step();

    Map<String, String> params();
}
