package com.cloudchipr.workflowengine.controller;

import com.cloudchipr.workflowengine.dto.WorkflowDto;
import com.cloudchipr.workflowengine.service.WorkflowService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workflows")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "${workflow-api.group.name}")
@Validated
public class WorkflowController {

    private final WorkflowService workflowService;

    @GetMapping
    List<WorkflowDto> findAll() {
        return workflowService.findAll();
    }


}
