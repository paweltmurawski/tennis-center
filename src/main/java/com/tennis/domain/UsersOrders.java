package com.tennis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name= "USERS_ORDERS")
public class UsersOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "usersOrders")
    private List<TennisProducts> tennisProducts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "TENNIS_CENTER_USERS_ID")
    private TennisCenterUsers tennisCenterUsers;
}
