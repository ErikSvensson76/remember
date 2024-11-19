package org.example.remember.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Objects;

public class ViewDate implements Serializable,Comparable<ViewDate> {

  private final LocalDate date;

  public ViewDate(LocalDate date) {
    this.date = date;
  }

  public LocalDate getDate() {
    return date;
  }

  public Integer getYear(){
    return date.getYear();
  }

  public Integer getDayOfWeek(){
    return date.getDayOfMonth();
  }

  public Integer getMonth(){
    return date.getMonthValue();
  }

  public Integer getWeekNumber(){
    return date.get(WeekFields.ISO.weekOfWeekBasedYear());
  }

  @Override
  public int compareTo(ViewDate o) {
    return date.compareTo(o.getDate());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ViewDate viewDate)) return false;
    return Objects.equals(date, viewDate.date);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(date);
  }

  @Override
  public String toString() {
    return date.toString();
  }
}
