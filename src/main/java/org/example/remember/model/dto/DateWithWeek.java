package org.example.remember.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public record DateWithWeek(
    LocalDate date,
    Integer week
)implements Serializable {
}
