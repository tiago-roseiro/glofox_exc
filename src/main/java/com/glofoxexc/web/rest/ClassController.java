package com.glofoxexc.web.rest;


import com.glofoxexc.service.BookingService;
import com.glofoxexc.service.ClassService;
import com.glofoxexc.service.dto.BookingDTO;
import com.glofoxexc.service.dto.ClassDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



/**
 * REST controller for managing the classes.
 */
@RestController
@RequestMapping("/class")
@Api(value = "Class Controller")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private BookingService bookingService;

    @ApiOperation(value = "Create a class", notes = "Creates classes based on a given date interval. Only 1 class per day is possible. Ex: If a class by\n" +
            "name pilates starts on 1st Dec and ends on 20th Dec, with capacity 10, that means Pilates\n" +
            "has 20 classes and for each class the maximum capacity of attendance is 10.\n")
    @PostMapping()
    public ResponseEntity<Void> createClass(@RequestBody ClassDTO classDTO){

    classService.addClass(classDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @ApiOperation(value = "Get a class", notes = "Returns a Class given a class ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Class retrieved with sucess"),
            @ApiResponse(code = 404, message = "Class not found!")
    })
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<ClassDTO> getClass(@PathVariable Long id){

        ClassDTO response = classService.getClass(id);

        return ResponseEntity.ok().body(response);

    }

    @ApiOperation(value = "Book a class", notes = "In a given day if there is a class created, this service books it for a given person. No need to consider the scenario of overbooking for a given date. Ex: 14th Dec having a\n" +
            "capacity of 20 , but the number of bookings can be greater than 20.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Class booked for given person and date with sucess!"),
            @ApiResponse(code = 404, message = "Class not found!")
    })
    @PostMapping(value = "/booking")
    public ResponseEntity<Void> createBooking(@RequestBody BookingDTO bookingDTO){

        bookingService.addBookingToClass(bookingDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
