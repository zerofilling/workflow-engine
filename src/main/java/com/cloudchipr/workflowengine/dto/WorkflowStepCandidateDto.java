package com.cloudchipr.workflowengine.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WorkflowStepCandidateDto extends AbstractDto {

    private Map<String, String> params;

    private WorkflowStepDto candidates;
}
