package com.glofoxexc.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {

    private String name;


    private LocalDate startDate;


    private LocalDate endDate;

    private int capacity;

}
