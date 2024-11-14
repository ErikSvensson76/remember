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
    Map<Integer, List<ViewDate>> dateWithWeekList;

    int y;
    int m;

    if(optionalYear.isPresent() && optionalMonth.isPresent()) {
      y = optionalYear.get();
      m = optionalMonth.get();
    }else if(optionalYear.isPresent()){
      y = optionalYear.get();
      m = YearMonth.of(y, 1).getMonthValue();
    }else if(optionalMonth.isPresent()){
      y = optionalMonth.get();
      m = Year.now().getValue();
    }else {
      y = Year.now().getValue();
      m = YearMonth.of(y, 1).getMonthValue();
    }
    dateWithWeekList = calenderService.getMonth(y, m).get();

    model.addAttribute("dates", dateWithWeekList);
    model.addAttribute("year", y);
    model.addAttribute("month", m);
    model.addAttribute("title", getMonth(m)+" "+y);

    return "calender";
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
