package com.cloudchipr.workflowengine.engine;

import com.cloudchipr.workflowengine.dto.ProcessStepDto;
import org.springframework.stereotype.Component;

@Component
public class StepsQueue {
    /**
     *
     * todo
     * Put next step to queue
     * Schedule run method ProcessEngine::executeFlow for step queued
     *
     * @param nextStep
     */
    public void addStepIntoQueue(ProcessStepDto nextStep) {

    }
}
