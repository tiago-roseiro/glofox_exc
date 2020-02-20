package com.glofoxexc.domain;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Class")
@Entity(name = "Class")
@Getter
@Setter
@Table(name = "class")
public class Class implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private int capacity;

    @OneToMany(mappedBy = "classes" , cascade = CascadeType.ALL, orphanRemoval =  true)
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking){
        bookings.add(booking);
        booking.setClasses(this);
    }
}
