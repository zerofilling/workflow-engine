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
public class WorkflowStepDto extends AbstractDto {

    private String id;

    private String name;

    private Map<String, String> params;

    private List<WorkflowStepCandidateDto> candidates;
}
