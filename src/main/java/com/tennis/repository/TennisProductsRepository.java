package com.tennis.repository;

import com.tennis.domain.TennisProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TennisProductsRepository extends CrudRepository<TennisProducts, Long> {
    @Override
    List<TennisProducts> findAll();

    @Override
    Optional<TennisProducts> findById(Long id);

    @Override
    TennisProducts save(TennisProducts tennisProducts);

    @Override
    void deleteById(Long id);
}
