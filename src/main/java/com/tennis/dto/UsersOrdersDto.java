package com.tennis.dto;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.domain.TennisProducts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsersOrdersDto {
    private Long id;
    private LocalDate orderDate;
    private List<TennisProducts> tennisProducts = new ArrayList<>();
    private TennisCenterUsers tennisCenterUsers;
}
