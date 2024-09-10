package com.cloudchipr.workflowengine.repository;

import com.cloudchipr.workflowengine.entity.ProcessStepEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProcessStepRepository extends CrudRepository<ProcessStepEntity, UUID> {
}
