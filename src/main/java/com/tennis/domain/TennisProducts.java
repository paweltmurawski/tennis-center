package com.tennis.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "TENNIS_PRODUCTS")
public class TennisProducts {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal productPrice;
    private List<UsersOrders> usersOrders = new ArrayList<>();
    private List<Cart> carts = new ArrayList<>();

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

    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "PRODUCT_PRICE")
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_ORDERS_PRODUCTS",
            joinColumns = {@JoinColumn(name = "TENNIS_PRODUCT_ID", referencedColumnName = "TENNIS_PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USERS_ORDERS_ID", referencedColumnName = "USERS_ORDER_ID")}
    )
    public List<UsersOrders> getUsersOrders() {
        return usersOrders;
    }

    public void setUsersOrders(List<UsersOrders> usersOrders) {
        this.usersOrders = usersOrders;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tennisProducts")
    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
