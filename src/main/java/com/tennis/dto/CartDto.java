package com.tennis.dto;

import com.tennis.domain.Payment;
import com.tennis.domain.TennisCenterUsers;
import com.tennis.domain.TennisProducts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private Payment payment;
    private List<TennisProducts> tennisProducts;
    private TennisCenterUsers tennisCenterUsers;
}
