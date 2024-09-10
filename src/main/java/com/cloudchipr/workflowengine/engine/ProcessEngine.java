package com.cloudchipr.workflowengine.engine;

import com.cloudchipr.workflowengine.dto.ProcessDto;
import com.cloudchipr.workflowengine.dto.ProcessStepDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProcessEngine {

    /**
     * Get Process Steps,
     * Validate the first step is in waiting status
     * Call executeStep() of first step
     *
     * @param process
     * @param params
     */
    void startProcess(ProcessDto process, Map<String, String> params) {

    }

    public void execute(ProcessStepDto step) {

    }
}
