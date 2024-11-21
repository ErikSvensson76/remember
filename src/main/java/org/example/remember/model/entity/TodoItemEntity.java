package org.example.remember.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = EntityUtils.TODO_ITEM_TABLE)
public class TodoItemEntity extends AuditEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = EntityUtils.TODO_ITEM_ID, updatable = false)
  private String id;
  @Column(name = EntityUtils.TODO_ITEM_TITLE)
  private String title;
  @Column(name = EntityUtils.TODO_ITEM_DESCRIPTION)
  private String description;
  @Column(name = EntityUtils.TODO_ITEM_PRIORITY)
  private Integer priority;
  @Column(name = EntityUtils.TODO_ITEM_DEADLINE)
  private LocalDateTime deadLine;
  @Column(name = EntityUtils.TODO_ITEM_DONE)
  private boolean done;

  public TodoItemEntity() {
  }

  public void setId(String id) {
    this.id = id;
  }

  public TodoItemEntity(
      String id,
      String title,
      String description,
      Integer priority,
      LocalDateTime deadLine,
      boolean done
  ) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.deadLine = deadLine;
    this.done = done;
  }

  public TodoItemEntity(
      String title,
      String description,
      Integer priority,
      LocalDateTime deadLine
  ) {
    this(null, title, description, priority, deadLine, false);
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
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
