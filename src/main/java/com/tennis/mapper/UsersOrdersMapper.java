package com.tennis.mapper;

import com.tennis.domain.UsersOrders;
import com.tennis.dto.UsersOrdersDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersOrdersMapper {
    public UsersOrders mapToUsersOrders(final UsersOrdersDto usersOrdersDto) {
        return new UsersOrders(
                usersOrdersDto.getId(),
                usersOrdersDto.getOrderDate(),
                usersOrdersDto.getTennisProducts(),
                usersOrdersDto.getTennisCenterUsers()
        );
    }

    public UsersOrdersDto mapToUsersOrdersDto(final UsersOrders usersOrders) {
        return new UsersOrdersDto(
                usersOrders.getId(),
                usersOrders.getOrderDate(),
                usersOrders.getTennisProducts(),
                usersOrders.getTennisCenterUsers()
        );
    }

    public List<UsersOrdersDto> mapToUsersOrdersDtoList(final List<UsersOrders> usersOrdersList) {
        return usersOrdersList.stream()
                .map(t -> new UsersOrdersDto(t.getId(), t.getOrderDate(), t.getTennisProducts(), t.getTennisCenterUsers()))
                .collect(Collectors.toList());
    }
}
