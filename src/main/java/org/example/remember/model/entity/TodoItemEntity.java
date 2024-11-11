package org.example.remember.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "todo_items")
public class TodoItemEntity extends AuditEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "pk_todo_item", updatable = false)
  private String id;
  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;
  @Column(name = "priority")
  private Integer priority;
  @Column(name = "dead_line")
  private LocalDateTime deadLine;

  public TodoItemEntity() {
  }

  public void setId(String id) {
    this.id = id;
  }

  public TodoItemEntity(String id, String title, String description, Integer priority, LocalDateTime deadLine) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.deadLine = deadLine;
  }

  public TodoItemEntity(String title, String description, Integer priority, LocalDateTime deadLine) {
    this(null, title, description, priority, deadLine);
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public LocalDateTime getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(LocalDateTime deadLine) {
    this.deadLine = deadLine;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TodoItemEntity that)) return false;
    return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(priority, that.priority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, priority);
  }
}
