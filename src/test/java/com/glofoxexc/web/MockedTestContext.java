package com.glofoxexc.web;

import com.glofoxexc.service.BookingService;
import com.glofoxexc.service.ClassService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

public class MockedTestContext {

    @Bean
    public ClassService classService() {
        return Mockito.mock(ClassService.class);
    }

    @Bean
    public BookingService bookingService() {
        return Mockito.mock(BookingService.class);
    }
}
