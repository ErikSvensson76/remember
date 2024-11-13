package org.example.remember.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewDateTest {

  @Test
  @DisplayName("When given ViewDate with date 2024-11-13, getDay return expected result")
  void getDaySuccess(){
    ViewDate viewDate = new ViewDate(LocalDate.of(2024, 11, 13), 11, 2024);
    String expected = "Onsdag";
    assertEquals(expected, viewDate.getDay());
  }

}