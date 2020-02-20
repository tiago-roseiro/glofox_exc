package com.glofoxexc.web.rest;


import com.glofoxexc.domain.Class;
import com.glofoxexc.service.BookingService;
import com.glofoxexc.service.ClassService;
import com.glofoxexc.service.dto.BookingDTO;
import com.glofoxexc.service.dto.ClassDTO;
import com.glofoxexc.web.MockedTestContext;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockedTestContext.class})
@WebAppConfiguration
public class ClassRestTest {


    private MockMvc mockMvc;

    @Autowired
    private ClassService classService;

    @Autowired
    private BookingService bookingService;


    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(new ClassController()).build();
    }

    @Test
    public void createClassTest() throws Exception {



        class AssignIdToClassAnswer implements Answer<Void> {

            private final Long id;

            public AssignIdToClassAnswer(Long id) {
                this.id = id;
            }

            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Class newClass = (Class) invocation.getArguments()[0];
                newClass.setId(id);
                return null;
            }
        }


        //given
        LocalDate startDate = LocalDate.of(2020, 02, 21);
        LocalDate endDate = LocalDate.of(2020, 02, 25);
        ClassDTO newClass = new ClassDTO("Pilates", startDate, endDate, 20);

        //when
        doAnswer(new AssignIdToClassAnswer(1L)).when(classService).addClass(newClass);

/*
        //then
        Gson gson = new Gson();
        //String reqjson = gson.toJson(newClass);

        String reqjson = TestUtil.convertObjectToJsonString(newClass);

        mockMvc.perform(post("/glofox/class")
                .content(reqjson)
                .contentType(TestUtil.APPLICATION_JSON)
                .contextPath("/glofox")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
*/

    }

    @Test
    public void createClassWithAlreadyExistingClassTest() throws Exception {
        //TODO
    }

    @Test
    public void createClassWithInvalidStartDateTest() throws Exception {
        //TODO


    }

    @Test
    public void createBookingTest() throws Exception {
        //TODO

    }

    @Test
    public void createBookingForClassThatDoesntExistTest() throws Exception {
        //TODO
    }
}
