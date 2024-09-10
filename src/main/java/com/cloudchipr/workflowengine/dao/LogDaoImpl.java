package com.cloudchipr.workflowengine.dao;

import com.cloudchipr.workflowengine.dto.LogLevel;
import com.cloudchipr.workflowengine.entity.LogEntity;
import com.cloudchipr.workflowengine.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogDaoImpl implements LogDao {

    private final LogRepository logRepository;
    private final ConversionService conversionService;

    @Override
    public void info(String message, String stepId, String userId, Map<String, String> params) {
        logRepository.save(LogEntity.builder()
                .logLevel(LogLevel.INFO)
                .message(message)
                .user(userId)
                .processStepId(conversionService.convert(stepId, UUID.class))
                .params(params).build());
    }
}
