package com.cloudchipr.workflowengine.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProcessFullDto extends WorkflowDto {

    private String name;

    private ProcessStepDto start;

    private WorkflowDto workflow;

}
