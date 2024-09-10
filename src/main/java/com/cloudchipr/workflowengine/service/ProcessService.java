package com.cloudchipr.workflowengine.service;

import com.cloudchipr.workflowengine.dto.ProcessDto;
import com.cloudchipr.workflowengine.dto.ProcessStepDto;

import java.util.Map;

public interface ProcessService {

    /**
     * Get Process Steps,
     * Validate the first step is in waiting status
     * Call executeStep() of first step
     *
     * @param process
     * @param params
     */
    void startProcess(ProcessDto process, Map<String, String> params);


    /**
     * This method is manual execution of step
     *
     * Validate and execute
     *
     * @param step
     */
    void executeStep(ProcessStepDto step);
}
