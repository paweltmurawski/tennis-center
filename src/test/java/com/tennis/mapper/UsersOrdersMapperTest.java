package com.tennis.mapper;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.domain.UsersOrders;
import com.tennis.dto.UsersOrdersDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersOrdersMapperTest {
    @Autowired
    private UsersOrdersMapper usersOrdersMapper;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToUsersOrders() {
        //Given
        UsersOrdersDto usersOrdersDto = new UsersOrdersDto(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));

        //When
        UsersOrders usersOrders = usersOrdersMapper.mapToUsersOrders(usersOrdersDto);

        //Then
        assertEquals(1L, usersOrders.getId(), 0);
        assertEquals(LocalDate.of(2019, 12, 2), usersOrders.getOrderDate());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToUsersOrdersDto() {
        //Given
        UsersOrders usersOrders = new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>()));

        //When
        UsersOrdersDto usersOrdersDto = usersOrdersMapper.mapToUsersOrdersDto(usersOrders);

        //Then
        assertEquals(1L, usersOrdersDto.getId(), 0);
        assertEquals(LocalDate.of(2019, 12, 2), usersOrdersDto.getOrderDate());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToUsersOrderDtoList() {
        //Given
        List<UsersOrders> usersOrdersList = new ArrayList<>();
        usersOrdersList.add(new UsersOrders(1L, LocalDate.of(2019, 12, 2), new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testemail@gmail.com", "Polna 3", "123456789", new ArrayList<>())));
        usersOrdersList.add(new UsersOrders(2L, LocalDate.of(2019, 12, 7), new ArrayList<>(), new TennisCenterUsers(2L, "Andrew W", "test2@gmail.com", "Suleckiego 18", "476395749", new ArrayList<>())));

        //When
        List<UsersOrdersDto> usersOrdersDtoList = usersOrdersMapper.mapToUsersOrdersDtoList(usersOrdersList);

        //Then
        assertEquals(1L, usersOrdersDtoList.get(0).getId(), 0);
        assertEquals(LocalDate.of(2019, 12, 2), usersOrdersDtoList.get(0).getOrderDate());
        assertEquals(2L, usersOrdersDtoList.get(1).getId(), 0);
        assertEquals(LocalDate.of(2019, 12, 7), usersOrdersDtoList.get(1).getOrderDate());
    }
}
