package com.tennis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "TENNIS_CENTER_USERS")
public class TennisCenterUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(
            targetEntity = UsersOrders.class,
            mappedBy = "tennisCenterUsers",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<UsersOrders> usersOrders = new ArrayList<>();
}
