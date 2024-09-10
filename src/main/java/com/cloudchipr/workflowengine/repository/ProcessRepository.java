package com.cloudchipr.workflowengine.repository;

import com.cloudchipr.workflowengine.entity.ProcessEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProcessRepository extends CrudRepository<ProcessEntity, UUID> {
}
