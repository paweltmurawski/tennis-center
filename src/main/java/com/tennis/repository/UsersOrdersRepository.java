package com.tennis.repository;

import com.tennis.domain.UsersOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UsersOrdersRepository extends CrudRepository<UsersOrders, Long> {
    @Override
    List<UsersOrders> findAll();
}
