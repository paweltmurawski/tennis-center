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
@Entity(name= "CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "PAYMENT")
    @Enumerated(EnumType.STRING)
    private Payment payment;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "JOIN_PRODUCTS_CARTS",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TENNIS_PRODUCTS_ID", referencedColumnName = "TENNIS_PRODUCTS_ID")}
    )
    private List<TennisProducts> tennisProducts = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TENNIS_CENTER_USERS_ID")
    private TennisCenterUsers tennisCenterUsers;
}
