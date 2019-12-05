package com.tennis.mapper;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.dto.TennisCenterUsersDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TennisCenterUsersMapper {
    public TennisCenterUsers mapToTennisCenterUsers(final TennisCenterUsersDto tennisCenterUsersDto) {
        return new TennisCenterUsers(
                tennisCenterUsersDto.getId(),
                tennisCenterUsersDto.getUsername(),
                tennisCenterUsersDto.getEmail(),
                tennisCenterUsersDto.getAddress(),
                tennisCenterUsersDto.getPhoneNumber(),
                tennisCenterUsersDto.getUsersOrders()
        );
    }

    public TennisCenterUsersDto mapToTennisCenterUsersDto(final TennisCenterUsers tennisCenterUsers) {
        return new TennisCenterUsersDto(
                tennisCenterUsers.getId(),
                tennisCenterUsers.getUsername(),
                tennisCenterUsers.getEmail(),
                tennisCenterUsers.getAddress(),
                tennisCenterUsers.getPhoneNumber(),
                tennisCenterUsers.getUsersOrders()
        );
    }

    public List<TennisCenterUsersDto> mapToTennisCenterUsersDtoList(final List<TennisCenterUsers> tennisCenterUsersList) {
        return tennisCenterUsersList.stream()
                .map(t -> new TennisCenterUsersDto(t.getId(), t.getUsername(), t.getEmail(), t.getAddress(), t.getPhoneNumber(), t.getUsersOrders()))
                .collect(Collectors.toList());
    }
}
