package com.cloudchipr.workflowengine.dto;

import com.cloudchipr.workflowengine.entity.WorkflowStepEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WorkflowFullDto extends WorkflowDto {

    private String name;

    private WorkflowStepDto start;

}
