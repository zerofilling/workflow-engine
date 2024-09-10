package com.cloudchipr.workflowengine.service;

import com.cloudchipr.workflowengine.dao.ProcessDao;
import com.cloudchipr.workflowengine.dto.ProcessDto;
import com.cloudchipr.workflowengine.dto.ProcessStepDto;
import com.cloudchipr.workflowengine.engine.ProcessEngine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final ProcessDao processDao;
    private final ProcessEngine processEngine;

    @Override
    public void startProcess(ProcessDto process, Map<String, String> params) {
        // validate, get step and call executeStep
//        todo executeFlow(find first step of process
    }

    @Override
    public void executeFlow(ProcessStepDto step) {
        processEngine.executeFlow(step);
    }
}
