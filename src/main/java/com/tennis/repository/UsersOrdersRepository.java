package com.tennis.repository;

import com.tennis.domain.UsersOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UsersOrdersRepository extends CrudRepository<UsersOrders, Long> {
    @Override
    List<UsersOrders> findAll();

    @Override
    Optional<UsersOrders> findById(Long id);

    @Override
    UsersOrders save(UsersOrders usersOrders);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
