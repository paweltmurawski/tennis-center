/*
package com.tennis.controller;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.dto.TennisCenterUsersDto;
import com.tennis.mapper.TennisCenterUsersMapper;
import com.tennis.service.TennisCenterUsersDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TennisCenterUsersController.class)
public class TennisCenterUsersControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TennisCenterUsersMapper tennisCenterUsersMapper;
    @MockBean
    private TennisCenterUsersDbService tennisCenterUsersDbService;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetTennisCenterUsers() throws Exception {
        //Given
        List<TennisCenterUsersDto> tennisCenterUsersList = new ArrayList<>();
        tennisCenterUsersList.add(new TennisCenterUsersDto(1L, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>()));
        tennisCenterUsersList.add(new TennisCenterUsersDto(2L, "Alex K", "test2@gmail.test", "Kaszubska 34", "648365937", new ArrayList<>()));

        when(tennisCenterUsersMapper.mapToTennisCenterUsersDtoList(tennisCenterUsersDbService.getAllTennisCenterUsers())).thenReturn(tennisCenterUsersList);

        //When & Then
        mockMvc.perform(get("/v1/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].username", is("Paul M")))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].username", is("Alex K")));
    }
}
*/