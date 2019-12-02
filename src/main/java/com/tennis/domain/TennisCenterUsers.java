package com.tennis.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TENNIS_CENTER_USERS")
public class TennisCenterUsers {
    private int id;
    private String username;
    private String email;
    private String address;
    private String phoneNumber;
    private List<UsersOrders> usersOrders = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(
            targetEntity = UsersOrders.class,
            mappedBy = "tennisCenterUsers",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<UsersOrders> getUsersOrders() {
        return usersOrders;
    }

    public void setUsersOrders(List<UsersOrders> usersOrders) {
        this.usersOrders = usersOrders;
    }
}
