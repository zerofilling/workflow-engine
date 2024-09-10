package com.cloudchipr.workflowengine.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProcessStepConfig {

    private StepType stepType;
    private StepExecutionType stepExecutionType;
}
