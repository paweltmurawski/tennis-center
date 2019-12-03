package com.tennis.repository;

import com.tennis.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    @Override
    List<Cart> findAll();
}
