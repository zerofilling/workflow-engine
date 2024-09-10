package com.cloudchipr.workflowengine.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProcessStepDto extends AbstractDto {

    private String id;

    private String processId;

    private String executor;

    private Map<String, String> params;

    private ProcessStatus status;

    private ProcessStepConfig config;

    private List<WorkflowStepCandidateDto> candidates;
}
