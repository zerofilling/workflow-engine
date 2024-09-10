package com.cloudchipr.workflowengine.repository;

import com.cloudchipr.workflowengine.entity.LogEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LogRepository extends CrudRepository<LogEntity, UUID> {
}
