package org.example.remember.controller;

import org.example.remember.model.dto.Pair;
import org.example.remember.model.dto.ViewDate;
import org.example.remember.service.calender.CalenderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/calendar")
public class CalenderController {

  private final CalenderService calenderService;

  public CalenderController(CalenderService calenderService) {
    this.calenderService = calenderService;
  }

  @SessionScope
  @GetMapping("")
  public String getCalendar(
      Model model,
      @RequestParam(name = "year", required = false) Integer year,
      @RequestParam(name = "month", required = false) Integer month) {
    Optional<Integer> optionalYear = Optional.ofNullable(year);
    Optional<Integer> optionalMonth = Optional.ofNullable(month);

    int y;
    int m;

    if(optionalYear.isPresent() && optionalMonth.isPresent()) {
      y = optionalYear.get();
      m = optionalMonth.get();
    } else {
      LocalDate today = LocalDate.now();
      y = today.getYear();
      m = today.getMonthValue();
    }

    List<Pair<Integer, List<ViewDate>>> weekBasedViewDates = calenderService.getWeekSequences(
        calenderService.getMonth(y,m)
    );

    model.addAttribute("dates", weekBasedViewDates);
    model.addAttribute("title", getMonth(m)+" "+y);
    model.addAttribute("year", y);
    model.addAttribute("month", m);

    return "calendar-view";
  }

  public String getMonth(int month){
      return switch (month){
        case 1 -> "Januari";
        case 2 -> "Februari";
        case 3 -> "Mars";
        case 4 -> "April";
        case 5 -> "Maj";
        case 6 -> "Juni";
        case 7 -> "Juli";
        case 8 -> "Augusti";
        case 9 -> "September";
        case 10 -> "Oktober";
        case 11 -> "November";
        case 12 -> "December";
        default -> throw new IllegalStateException("Unexpected value: " + month);
      };
  }


}
