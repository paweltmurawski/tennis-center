package com.tennis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name= "TENNIS_PRODUCTS")
public class TennisProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRODUCT_PRICE")
    private BigDecimal productPrice;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "JOIN_ORDERS_PRODUCTS",
            joinColumns = {@JoinColumn(name = "TENNIS_PRODUCT_ID", referencedColumnName = "TENNIS_PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USERS_ORDERS_ID", referencedColumnName = "USERS_ORDER_ID")}
    )
    private List<UsersOrders> usersOrders = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tennisProducts")
    private List<Cart> carts = new ArrayList<>();
}
