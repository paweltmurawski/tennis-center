package com.tennis.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "USERS_ORDERS")
public class UsersOrders {
    private Long id;
    private LocalDate orderDate;
    private List<TennisProducts> tennisProducts = new ArrayList<>();
    private TennisCenterUsers tennisCenterUsers;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ORDER_DATE")
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "usersOrders")
    public List<TennisProducts> getTennisProducts() {
        return tennisProducts;
    }

    public void setTennisProducts(List<TennisProducts> tennisProducts) {
        this.tennisProducts = tennisProducts;
    }

    @ManyToOne
    @JoinColumn(name = "TENNIS_CENTER_USERS_ID")
    public TennisCenterUsers getTennisCenterUsers() {
        return tennisCenterUsers;
    }

    public void setTennisCenterUsers(TennisCenterUsers tennisCenterUsers) {
        this.tennisCenterUsers = tennisCenterUsers;
    }
}
