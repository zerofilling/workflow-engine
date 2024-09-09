package com.cloudchipr.workflowengine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "process")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProcessEntity extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkflowEntity workflow;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProcessStepEntity start;

}
