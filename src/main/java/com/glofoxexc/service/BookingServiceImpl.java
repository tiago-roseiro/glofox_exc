package com.glofoxexc.service;

import com.glofoxexc.domain.Booking;
import com.glofoxexc.domain.Class;
import com.glofoxexc.repository.BookingRepository;
import com.glofoxexc.repository.ClassRepository;
import com.glofoxexc.service.dto.BookingDTO;
import com.glofoxexc.service.exception.ClassNotFoundException;
import com.glofoxexc.service.exception.InvalidDatesException;
import com.glofoxexc.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    Validator validator;


    public void addBookingToClass(BookingDTO bookingDTO){


        if(validator.validateBookingDate(bookingDTO.getDate())){

            Class currentClass = classRepository.findClassByStartDate(bookingDTO.getDate());
            if(currentClass == null){
                throw new ClassNotFoundException("Class not found!");
            }

            Booking newBooking = new Booking();
            newBooking.setName(bookingDTO.getName());
            newBooking.setDate(bookingDTO.getDate());
            currentClass.addBooking(newBooking);
            bookingRepository.save(newBooking);
        } else {
            throw new InvalidDatesException("The input date is invalid!");
        }

    }
}
