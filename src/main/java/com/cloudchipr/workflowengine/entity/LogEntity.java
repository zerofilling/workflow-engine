package com.cloudchipr.workflowengine.entity;

import com.cloudchipr.workflowengine.dto.LogLevel;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "execution_log")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LogEntity extends AbstractEntity {

    private String user;
    private UUID processStepId;
    private String message;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> params;
    @Enumerated
    private LogLevel logLevel;
}
