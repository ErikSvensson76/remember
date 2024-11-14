package org.example.remember.service.calender;

import org.example.remember.model.dto.ViewDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CalenderService {


  public Supplier<List<LocalDate>> getYear(final Integer year){
    if(year == null) throw new IllegalArgumentException("year is null");
    return () -> {
      int days = Year.of(year).length();
      List<LocalDate> fullYear = new ArrayList<>();
      for(int i = 1; i <= days; i++){
        fullYear.add(LocalDate.ofYearDay(year, i));
      }
      return fullYear;
    };
  }

  public Supplier<Map<Integer, List<ViewDate>>> getMonth(final Integer year, final Integer month){
    if(month == null) throw new IllegalArgumentException("month is null");
    return () -> {
      Year currentYear = year == null ? Year.now() : Year.of(year);
      LocalDate firstDayOfMonth = YearMonth.of(currentYear.getValue(), month).atDay(1);
      LocalDate lastDayOfMonth = YearMonth.of(currentYear.getValue(), month).atEndOfMonth();
      int startDay = firstDayOfMonth.getDayOfWeek().getValue();
      int endDay = lastDayOfMonth.getDayOfWeek().getValue();
      LocalDate calendarStartDate = startDay != 1 ? firstDayOfMonth.minusDays(startDay - 1L) : firstDayOfMonth;
      LocalDate calendarEndDate = endDay != 7 ? lastDayOfMonth.plusDays((7 - endDay)) : lastDayOfMonth;
      return Stream.iterate(
            calendarStartDate,
            date -> date.isBefore(calendarEndDate.plusDays(1)),
            localDate -> localDate.plusDays(1))
          .map(ViewDate::new)
          .collect(Collectors.groupingBy(ViewDate::getWeekNumber));
    };
  }






}
