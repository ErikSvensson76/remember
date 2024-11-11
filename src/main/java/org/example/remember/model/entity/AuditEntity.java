package org.example.remember.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public class AuditEntity {

  @Column(name = "created", updatable = false)
  private LocalDateTime createdAt;
  @Column(name = "last_modifier")
  private LocalDateTime updatedAt;

  @PrePersist
  void onPersist(){
    LocalDateTime now = LocalDateTime.now();
    setCreatedAt(now);
    setUpdatedAt(now);
  }

  @PreUpdate
  void onUpdate(){
    setUpdatedAt(LocalDateTime.now());
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
