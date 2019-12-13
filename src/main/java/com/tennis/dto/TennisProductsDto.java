package com.tennis.dto;

import com.tennis.domain.Cart;
import com.tennis.domain.UsersOrders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TennisProductsDto {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal productPrice;
    private List<UsersOrders> usersOrders;
    private List<Cart> carts;
}
