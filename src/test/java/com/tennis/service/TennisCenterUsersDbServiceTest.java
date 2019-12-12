package com.tennis.service;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.repository.TennisCenterUsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TennisCenterUsersDbServiceTest {
    @InjectMocks
    private TennisCenterUsersDbService tennisCenterUsersDbService;
    @Mock
    private TennisCenterUsersRepository tennisCenterUsersRepository;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetAllTennisCenterUsers() {
        //When
        List<TennisCenterUsers> tennisCenterUsersList = new ArrayList<>();
        tennisCenterUsersList.add(new TennisCenterUsers(1L, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>()));
        tennisCenterUsersList.add(new TennisCenterUsers(2L, "Alex K", "test2@gmail.test", "Kaszubska 34", "648365937", new ArrayList<>()));

        when(tennisCenterUsersRepository.findAll()).thenReturn(tennisCenterUsersList);

        //When
        List<TennisCenterUsers> currentTennisCenterUsersList = tennisCenterUsersDbService.getAllTennisCenterUsers();

        //Then
        assertEquals(tennisCenterUsersList, currentTennisCenterUsersList);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetTennisCenterUserById() {
        //Given
        TennisCenterUsers tennisCenterUsers = (new TennisCenterUsers(1L, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>()));

        when(tennisCenterUsersRepository.findById(1L)).thenReturn(Optional.of(tennisCenterUsers));

        //When
        Optional<TennisCenterUsers> findTennisCenterUser = tennisCenterUsersDbService.getTennisCenterUserById(1L);

        //Then
        assertEquals(tennisCenterUsers, findTennisCenterUser.get());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testSaveTennisCenterUser() {
        //Given
        TennisCenterUsers tennisCenterUsers = (new TennisCenterUsers(1L, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>()));

        when(tennisCenterUsersRepository.save(tennisCenterUsers)).thenReturn(tennisCenterUsers);

        //When
        TennisCenterUsers savedTennisCenterUsers = tennisCenterUsersDbService.saveTennisCenterUser(tennisCenterUsers);

        //Then
        assertEquals(tennisCenterUsers, savedTennisCenterUsers);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteTennisCenterUser() {
        //Given
        TennisCenterUsers tennisCenterUsers = (new TennisCenterUsers(1L, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>()));
        tennisCenterUsersDbService.saveTennisCenterUser(tennisCenterUsers);

        //When
        tennisCenterUsersDbService.deleteTennisCenterUserById(1L);

        //Then
        Mockito.verify(tennisCenterUsersRepository).deleteById(1L);
    }
}
