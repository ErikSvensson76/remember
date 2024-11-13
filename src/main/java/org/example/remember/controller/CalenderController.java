package org.example.remember.controller;

import org.example.remember.model.dto.ViewDate;
import org.example.remember.service.calender.CalenderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/calender")
public class CalenderController {

  private final CalenderService calenderService;

  public CalenderController(CalenderService calenderService) {
    this.calenderService = calenderService;
  }

  @GetMapping()
  public String calender(
      Model model,
      @RequestParam(name = "year", required = false) Integer year,
      @RequestParam(name = "month", required = false) Integer month) {
    Optional<Integer> optionalYear = Optional.ofNullable(year);
    Optional<Integer> optionalMonth = Optional.ofNullable(month);
    List<ViewDate> dateWithWeekList;

    if(optionalYear.isPresent() && optionalMonth.isPresent()) {
      dateWithWeekList = calenderService.getMonth(optionalYear.get(),optionalMonth.get()).get();

    }else if(optionalYear.isPresent()){
      int y = optionalYear.get();
      int m = YearMonth.of(y, 1).getMonthValue();
      dateWithWeekList = calenderService.getMonth(y, m).get();
    }else if(optionalMonth.isPresent()){
      int y = optionalMonth.get();
      int m = Year.now().getValue();
      dateWithWeekList = calenderService.getMonth(y, m).get();
    }else {
      int y = Year.now().getValue();
      int m = YearMonth.of(y, 1).getMonthValue();
      dateWithWeekList = calenderService.getMonth(y, m).get();
    }

    Map<Integer,List<ViewDate>> map = dateWithWeekList.stream()
            .collect(Collectors.groupingBy(ViewDate::getWeekNumber));


    model.addAttribute("dates", map);
    return "calender";
  }

}
