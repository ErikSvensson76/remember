package org.example.remember.model.input;

import java.time.LocalDateTime;

public class TodoItemInput {
  private String id;
  private String title;
  private String description;
  private Integer priority;
  private LocalDateTime deadLine;

  public TodoItemInput(String id, String title, String description, Integer priority, LocalDateTime deadLine) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.deadLine = deadLine;
  }

  public TodoItemInput() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

}
