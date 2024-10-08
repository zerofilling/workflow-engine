package com.cloudchipr.workflowengine.service;

import com.cloudchipr.workflowengine.dao.WorkflowDao;
import com.cloudchipr.workflowengine.dto.WorkflowDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowDao workflowDao;
    private final ConversionService conversionService;

    @Override
    public List<WorkflowDto> findAll() {
        return StreamSupport.stream(workflowDao.findAll().spliterator(), false)
                .map(it -> conversionService.convert(it, WorkflowDto.class)).collect(Collectors.toList());
    }
}
