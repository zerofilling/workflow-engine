package com.cloudchipr.workflowengine.dao;

import com.cloudchipr.workflowengine.dto.WorkflowDto;

import java.util.List;

public interface WorkflowDao {
    List<WorkflowDto> findAll();
}
