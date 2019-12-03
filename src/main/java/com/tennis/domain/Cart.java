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
@Table(name= "CART")
public class Cart {
    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
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

    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "PRODUCT_PRICE")
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Column(name = "PRODUCT_QUANTITY")
    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CART_PRODUCTS",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TENNIS_PRODUCTS_ID", referencedColumnName = "TENNIS_PRODUCTS_ID")}
    )
    public List<TennisProducts> getTennisProducts() {
        return tennisProducts;
    }

    public void setTennisProducts(List<TennisProducts> tennisProducts) {
        this.tennisProducts = tennisProducts;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TENNIS_CENTER_USERS_ID")
    public TennisCenterUsers getTennisCenterUsers() {
        return tennisCenterUsers;
    }

    public void setTennisCenterUsers(TennisCenterUsers tennisCenterUsers) {
        this.tennisCenterUsers = tennisCenterUsers;
    }
}
