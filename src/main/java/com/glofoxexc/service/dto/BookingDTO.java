package com.glofoxexc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;



import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookingDTO {

    private String name;

    private LocalDate date;

}
