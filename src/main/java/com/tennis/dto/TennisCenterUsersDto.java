package com.tennis.dto;

import com.tennis.domain.UsersOrders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TennisCenterUsersDto {
    private Long id;
    private String username;
    private String email;
    private String address;
    private String phoneNumber;
    private List<UsersOrders> usersOrders;
}
