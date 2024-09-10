package com.cloudchipr.workflowengine.service;

import com.cloudchipr.workflowengine.dto.ProcessDto;
import com.cloudchipr.workflowengine.dto.ProcessStepDto;
import com.cloudchipr.workflowengine.engine.ProcessEngine;
import com.cloudchipr.workflowengine.repository.ProcessRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;
    private final ProcessEngine processEngine;

    @Override
    public void startProcess(ProcessDto process, Map<String, String> params) {
        // validate, get step and call executeStep
    }

    @Override
    public void executeStep(ProcessStepDto step) {
        processEngine.execute(step);
    }
}
