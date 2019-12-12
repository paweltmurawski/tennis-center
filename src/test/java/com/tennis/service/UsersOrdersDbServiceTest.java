package com.tennis.service;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.domain.UsersOrders;
import com.tennis.repository.UsersOrdersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsersOrdersDbServiceTest {
    @InjectMocks
    private UsersOrdersDbService usersOrdersDbService;
    @Mock
    private UsersOrdersRepository usersOrdersRepository;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetAllUsersOrders() {
        //Given
        List<UsersOrders> usersOrdersList = new ArrayList<>();
        usersOrdersList.add(new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>())));
        usersOrdersList.add(new UsersOrders(2L, LocalDate.of(2019, 12, 7), new ArrayList<>(), new TennisCenterUsers(2L, "Andrew W", "test2@gmail.com", "Suleckiego 18", "476395749", new ArrayList<>())));

        when(usersOrdersRepository.findAll()).thenReturn(usersOrdersList);

        //When
        List<UsersOrders> currentUsersOrdersList = usersOrdersDbService.getAllUsersOrders();

        //Then
        assertEquals(usersOrdersList, currentUsersOrdersList);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetUserOrderById() {
        //Given
        UsersOrders usersOrders = new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));

        when(usersOrdersRepository.findById(1L)).thenReturn(Optional.of(usersOrders));

        //When
        Optional<UsersOrders> findUserOrder = usersOrdersDbService.getUserOrderById(1L);

        //Then
        assertEquals(usersOrders, findUserOrder.get());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testSaveUserOrder() {
        //Given
        UsersOrders usersOrders = new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));

        when(usersOrdersRepository.save(usersOrders)).thenReturn(usersOrders);

        //When
        UsersOrders savedUsersOrders = usersOrdersDbService.saveUserOrder(usersOrders);

        //Then
        assertEquals(usersOrders, savedUsersOrders);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteUserOrder() {
        //Given
        UsersOrders usersOrders = new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));
        usersOrdersDbService.saveUserOrder(usersOrders);

        //When
        usersOrdersDbService.deleteUserOrderById(1L);

        //Then
        Mockito.verify(usersOrdersRepository).deleteById(1L);
    }
}
