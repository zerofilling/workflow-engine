package com.cloudchipr.workflowengine.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WorkflowDto extends AbstractDto {

    private String id;

    private String name;

}
