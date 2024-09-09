package com.cloudchipr.workflowengine.repository;

import com.cloudchipr.workflowengine.entity.WorkflowEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface WorkflowRepository extends CrudRepository<WorkflowEntity, UUID> {
}
