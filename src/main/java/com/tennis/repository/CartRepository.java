package com.tennis.repository;

import com.tennis.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    @Override
    List<Cart> findAll();

    @Override
    Optional<Cart> findById(Long id);

    @Override
    Cart save(Cart cart);

    @Override
    void deleteById(Long id);
}
