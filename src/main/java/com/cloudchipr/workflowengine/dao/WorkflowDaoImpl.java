package com.cloudchipr.workflowengine.dao;

import com.cloudchipr.workflowengine.dto.WorkflowDto;
import com.cloudchipr.workflowengine.repository.WorkflowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class WorkflowDaoImpl implements WorkflowDao {

    private final WorkflowRepository workflowRepository;
    private final ConversionService conversionService;

    @Override
    public List<WorkflowDto> findAll() {
        return StreamSupport.stream(workflowRepository.findAll().spliterator(), false)
                .map(it -> conversionService.convert(it, WorkflowDto.class)).collect(Collectors.toList());
    }
}
