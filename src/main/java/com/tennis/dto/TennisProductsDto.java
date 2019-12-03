package com.tennis.dto;

import com.tennis.domain.Cart;
import com.tennis.domain.UsersOrders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TennisProductsDto {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal productPrice;
    private List<UsersOrders> usersOrders = new ArrayList<>();
    private List<Cart> carts = new ArrayList<>();
}
