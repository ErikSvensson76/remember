package org.example.remember.service.calender;

import org.example.remember.model.dto.DateWithWeek;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = CalenderService.class)
class CalenderServiceTest {

  @Autowired
  CalenderService underTest;


  @Test
  void getYear() {
    Year year = Year.of(Year.now().getValue());

    List<LocalDate> result = underTest.getYear(year.getValue()).get();

    assertNotNull(result);
    assertFalse(result.isEmpty(), "result is empty");
  }

  @ParameterizedTest
  @EnumSource(Month.class)
  void getMonths(Month month){
    int year = Year.now().getValue();
     List<DateWithWeek> result = underTest.getMonth(year,month.getValue()).get();
     assertNotNull(result);

  }



}