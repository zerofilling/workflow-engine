package com.cloudchipr.workflowengine.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@Table(name = "step_candidate")
@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WorkflowStepCandidateEntity extends AbstractEntity {

    @ManyToOne
    private WorkflowStepEntity step;

//    @Type(JsonType.class)
//    @Column(columnDefinition = "jsonb")
//    private Map<String, String> params;
}
