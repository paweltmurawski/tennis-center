package com.tennis.repository;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.domain.UsersOrders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersOrdersRepositoryTestSuite {
    @Autowired
    private UsersOrdersRepository usersOrdersRepository;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testCreateUsersOrdersRepository() {
        //Given
        UsersOrders usersOrders = new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));

        //When
        usersOrdersRepository.save(usersOrders);
        int countUsersOrders = usersOrdersRepository.findAll().size();

        //Then
        assertEquals(1, countUsersOrders);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testReadUsersOrdersRepository() {
        //Given
        UsersOrders usersOrders = new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));

        //When
        usersOrdersRepository.save(usersOrders);
        UsersOrders readUsersOrders = usersOrdersRepository.findById(1L).orElse(null);

        //Then
        assertEquals(usersOrders, readUsersOrders);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testUpdateUsersOrdersRepository() {
        //Given
        UsersOrders usersOrders = new UsersOrders(1L, LocalDate.of(2019, 11, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));
        usersOrdersRepository.save(usersOrders);

        //When
        UsersOrders updatedDate = new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));
        usersOrdersRepository.save(updatedDate);
        UsersOrders updatedUsersOrders = usersOrdersRepository.findById(1L).orElse(null);

        //Then
        assertEquals(updatedDate, updatedUsersOrders);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteUsersOrdersRepository() {
        //Given
        UsersOrders usersOrders = new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));
        usersOrdersRepository.save(usersOrders);

        //When
        usersOrdersRepository.deleteById(1L);
        UsersOrders deletedUsersOrders = usersOrdersRepository.findById(1L).orElse(null);

        //Then
        assertNull(deletedUsersOrders);
    }
}
