package com.tennis.mapper;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.dto.TennisCenterUsersDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TennisCenterUsersMapperTest {
    @Autowired
    private TennisCenterUsersMapper tennisCenterUsersMapper;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToTennisCenterUsers() {
        //Given
        TennisCenterUsersDto tennisCenterUsersDto = new TennisCenterUsersDto(1L, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>());

        //When
        TennisCenterUsers tennisCenterUsers = tennisCenterUsersMapper.mapToTennisCenterUsers(tennisCenterUsersDto);

        //Then
        assertEquals(1L, tennisCenterUsers.getId(), 0);
        assertEquals("Paul M", tennisCenterUsers.getUsername());
        assertEquals("testEmail@gmail.com", tennisCenterUsers.getEmail());
        assertEquals("Warszawska 4", tennisCenterUsers.getAddress());
        assertEquals("123456789", tennisCenterUsers.getPhoneNumber());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToTennisCenterUsersDto() {
        //Given
        TennisCenterUsers tennisCenterUsers = new TennisCenterUsers(1L, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>());

        //When
        TennisCenterUsersDto tennisCenterUsersDto = tennisCenterUsersMapper.mapToTennisCenterUsersDto(tennisCenterUsers);

        //Then
        assertEquals(1L, tennisCenterUsersDto.getId(), 0);
        assertEquals("Paul M", tennisCenterUsersDto.getUsername());
        assertEquals("testEmail@gmail.com", tennisCenterUsersDto.getEmail());
        assertEquals("Warszawska 4", tennisCenterUsersDto.getAddress());
        assertEquals("123456789", tennisCenterUsersDto.getPhoneNumber());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToTennisCenterUsersDtoList() {
        //Given
        List<TennisCenterUsers> tennisCenterUsersList = new ArrayList<>();
        tennisCenterUsersList.add(new TennisCenterUsers(1L, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>()));
        tennisCenterUsersList.add(new TennisCenterUsers(2L, "Alex K", "test2@gmail.test", "Kaszubska 34", "648365937", new ArrayList<>()));

        //When
        List<TennisCenterUsersDto> tennisCenterUsersDtoList = tennisCenterUsersMapper.mapToTennisCenterUsersDtoList(tennisCenterUsersList);

        //Then
        assertEquals(1L, tennisCenterUsersDtoList.get(0).getId(), 0);
        assertEquals("Paul M", tennisCenterUsersDtoList.get(0).getUsername());
        assertEquals("testEmail@gmail.com", tennisCenterUsersDtoList.get(0).getEmail());
        assertEquals("Warszawska 4", tennisCenterUsersDtoList.get(0).getAddress());
        assertEquals("123456789", tennisCenterUsersDtoList.get(0).getPhoneNumber());
        assertEquals(2L, tennisCenterUsersDtoList.get(1).getId(), 0);
        assertEquals("Alex K", tennisCenterUsersDtoList.get(1).getUsername());
        assertEquals("test2@gmail.test", tennisCenterUsersDtoList.get(1).getEmail());
        assertEquals("Kaszubska 34", tennisCenterUsersDtoList.get(1).getAddress());
        assertEquals("648365937", tennisCenterUsersDtoList.get(1).getPhoneNumber());
    }
}
