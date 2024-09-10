package com.cloudchipr.workflowengine.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Map;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LogDto extends AbstractDto {

    private String user;
    private UUID processStepId;
    private String message;
    private Map<String, String> params;
    private LogLevel logLevel;

}
