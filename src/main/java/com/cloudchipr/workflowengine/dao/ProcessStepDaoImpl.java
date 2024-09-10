package com.cloudchipr.workflowengine.dao;

import com.cloudchipr.workflowengine.entity.ProcessStepEntity;
import com.cloudchipr.workflowengine.repository.ProcessStepRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProcessStepDaoImpl implements ProcessStepDao {

    private final ProcessStepRepository processStepRepository;
    private final ConversionService conversionService;

    @Override
    public void saveParams(String stepId, Map<String, String> params) {
        ProcessStepEntity processStep = processStepRepository
                .findById(Objects.requireNonNull(conversionService.convert(stepId, UUID.class)))
                .orElseThrow(() -> new RuntimeException("Step not found"));
        processStep.setParams(params);
        processStepRepository.save(processStep);
    }
}
