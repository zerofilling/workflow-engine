package com.cloudchipr.workflowengine.service;

import com.cloudchipr.workflowengine.dto.WorkflowDto;

import java.util.List;

public interface WorkflowService {
    List<WorkflowDto> findAll();
}
