package org.example.remember.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Audit implements Serializable {

  private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;

  public Audit(LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

}
