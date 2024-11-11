package org.example.remember.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TodoItem extends Audit {

  private final String id;
  private final String title;
  private final String description;
  private final Integer priority;
  private final LocalDate deadLineDate;
  private final LocalTime deadLineTime;

  public TodoItem (
     LocalDateTime createdAt,
     LocalDateTime updatedAt,
     String id,
     String title,
     String description,
     Integer priority,
     LocalDate deadLineDate,
     LocalTime deadLineTime
  ){
    super(createdAt, updatedAt);
    this.id = id;
    this.title = title;
    this.description = description;
    this.priority = priority;
    this.deadLineDate = deadLineDate;
    this.deadLineTime = deadLineTime;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public Integer getPriority() {
    return priority;
  }

  public LocalDate getDeadLineDate() {
    return deadLineDate;
  }

  public LocalTime getDeadLineTime() {
    return deadLineTime;
  }

}
