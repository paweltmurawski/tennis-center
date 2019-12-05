package com.tennis.service;

import com.tennis.domain.UsersOrders;
import com.tennis.repository.UsersOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersOrdersDbService {
    @Autowired
    private UsersOrdersRepository usersOrdersRepository;

    public List<UsersOrders> getAllUsersOrders() {
        return usersOrdersRepository.findAll();
    }

    public Optional<UsersOrders> getUserOrderById(final Long id) {
        return usersOrdersRepository.findById(id);
    }

    public UsersOrders saveUserOrder(final UsersOrders usersOrders) {
        return usersOrdersRepository.save(usersOrders);
    }

    public void deleteUserOrderById(final Long id) {
        usersOrdersRepository.deleteById(id);
    }
}
