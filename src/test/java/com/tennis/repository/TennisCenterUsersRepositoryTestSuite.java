package com.tennis.repository;

import com.tennis.domain.TennisCenterUsers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TennisCenterUsersRepositoryTestSuite {
    @Autowired
    private TennisCenterUsersRepository tennisCenterUsersRepository;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testCreateTennisCenterUsersRepository() {
        //Given
        TennisCenterUsers tennisCenterUsers = new TennisCenterUsers(1, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>());

        //When
        tennisCenterUsersRepository.save(tennisCenterUsers);
        int countTennisCenterUsers = tennisCenterUsersRepository.findAll().size();

        //Then
        assertEquals(1, countTennisCenterUsers);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testReadTennisCenterUsersRepository() {
        //Given
        TennisCenterUsers tennisCenterUsers = new TennisCenterUsers(1, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>());

        //When
        tennisCenterUsersRepository.save(tennisCenterUsers);
        TennisCenterUsers readTennisCenterUsers = tennisCenterUsersRepository.findById(1).orElse(null);

        //Then
        assertEquals(tennisCenterUsers, readTennisCenterUsers);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testUpdateTennisCenterUsersRepository() {
        //Given
        TennisCenterUsers tennisCenterUsers = new TennisCenterUsers(1, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>());
        tennisCenterUsersRepository.save(tennisCenterUsers);

        //When
        TennisCenterUsers updatedAddress = new TennisCenterUsers(1, "Paul M", "testEmail@gmail.com", "Smocza 6", "123456789", new ArrayList<>());
        tennisCenterUsersRepository.save(updatedAddress);
        TennisCenterUsers updatedTennisCenterUsers = tennisCenterUsersRepository.findById(1).orElse(null);

        //Then
        assertEquals(updatedAddress, updatedTennisCenterUsers);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteTennisCenterUsersRepository() {
        //Given
        TennisCenterUsers tennisCenterUsers = new TennisCenterUsers(1, "Paul M", "testEmail@gmail.com", "Warszawska 4", "123456789", new ArrayList<>());
        tennisCenterUsersRepository.save(tennisCenterUsers);

        //When
        tennisCenterUsersRepository.deleteById(1);
        TennisCenterUsers deletedTennisCenterUsers = tennisCenterUsersRepository.findById(1).orElse(null);

        //Then
        assertNull(deletedTennisCenterUsers);

    }
}
