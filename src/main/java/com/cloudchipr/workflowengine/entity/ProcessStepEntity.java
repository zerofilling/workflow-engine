package com.cloudchipr.workflowengine.entity;

import com.cloudchipr.workflowengine.dto.ProcessStatus;
import com.cloudchipr.workflowengine.dto.ProcessStepConfig;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "process_step")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProcessStepEntity extends AbstractEntity {

    private String name;
    private String executor;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> params;

    @Enumerated
    private ProcessStatus status;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private ProcessStepConfig config;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProcessStepCandidateEntity> candidates;
}
