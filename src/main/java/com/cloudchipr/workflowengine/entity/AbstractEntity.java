package com.cloudchipr.workflowengine.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Slf4j
public class AbstractEntity {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(name = "creation_timestamp", updatable = false, nullable = false)
  private Instant creationTimestamp;

  @org.springframework.data.annotation.Version
  @UpdateTimestamp
  @Column(nullable = false)
  private Instant updatedTimestamp;

  @PrePersist
  protected void prePersist() {
    creationTimestamp = Instant.now();
    prepareForPersist();
  }

  @PreUpdate
  protected void preUpdate() {
    updatedTimestamp = Instant.now();
    prepareForUpdate();
  }

  protected AbstractEntity prepareForPersist() {
    log.trace("Calling default method for prepareForSave");
    return this;
  }

  protected AbstractEntity prepareForUpdate() {
    log.trace("Calling default method for prepareForSave");
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractEntity that = (AbstractEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
