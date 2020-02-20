package com.glofoxexc.validation;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Validator {

    public boolean validateClassDates(LocalDate startDate, LocalDate endDate){

        boolean isValid = false;
        LocalDate todayDate = LocalDate.now();

        if((startDate.isAfter(todayDate) && endDate.isAfter(todayDate)) && (endDate.isAfter(startDate)) ){
            isValid = true;
        }

        return isValid;

    }

    public boolean validateBookingDate(LocalDate date){

        boolean isValid = false;
        LocalDate todayDate = LocalDate.now();

        if(date.isAfter(todayDate.minusDays(1))){
            isValid = true;
        }
        return isValid;
    }
}

