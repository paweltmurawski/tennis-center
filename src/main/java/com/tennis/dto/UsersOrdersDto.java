package com.tennis.dto;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.domain.TennisProducts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersOrdersDto {
    private Long id;
    private LocalDate orderDate;
    private List<TennisProducts> tennisProducts;
    private TennisCenterUsers tennisCenterUsers;
}
