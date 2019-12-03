package com.tennis.dto;

import com.tennis.domain.TennisCenterUsers;
import com.tennis.domain.TennisProducts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private List<TennisProducts> tennisProducts = new ArrayList<>();
    private TennisCenterUsers tennisCenterUsers;
}
