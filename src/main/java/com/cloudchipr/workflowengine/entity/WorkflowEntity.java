package com.cloudchipr.workflowengine.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "workflow")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WorkflowEntity extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    private WorkflowStepEntity start;

}
