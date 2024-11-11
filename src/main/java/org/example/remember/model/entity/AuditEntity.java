package org.example.remember.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public class AuditEntity {

  @Column(name = "created", updatable = false)
  private LocalDateTime createdAt;
  @Column(name = "last_modifier", insertable = false)
  private LocalDateTime updatedAt;

  @PrePersist
  void onPersist(){
    this.createdAt = LocalDateTime.now();
  }

  void onUpdate(){
    this.updatedAt = LocalDateTime.now();
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
}
