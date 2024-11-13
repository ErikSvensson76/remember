package org.example.remember.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Objects;

public class ViewDate implements Serializable {

  private final LocalDate date;
  private final Integer month;
  private final Integer year;

  public ViewDate(LocalDate date, Integer month, Integer year) {
    this.date = date;
    this.month = month;
    this.year = year;
  }

  public Integer getYear(){
    return year;
  }

  public Integer getWeekNumber(){
    return date.get(WeekFields.ISO.weekOfWeekBasedYear());
  }

  public boolean isGrayedOut(){
    return date.getMonthValue() != month;
  }

  public String getDay(){
    return switch (date.getDayOfWeek().getValue()) {
      case 1 -> "Måndag";
      case 2 -> "Tisdag";
      case 3 -> "Onsdag";
      case 4 -> "Torsdag";
      case 5 -> "Fredag";
      case 6 -> "Lördag";
      case 7 -> "Söndag";
      default -> throw new IllegalArgumentException("Invalid day");
    };
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
}
