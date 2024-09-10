package com.cloudchipr.workflowengine.entity;

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

@Entity
@Table(name = "step")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WorkflowStepCandidateEntity extends AbstractEntity {

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> params;

    private String executor;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private WorkflowStepEntity step;
}
