package com.tennis.repository;

import com.tennis.domain.TennisProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Repository
public interface TennisProductRepository extends CrudRepository<TennisProducts, Integer> {
    ArrayList<TennisProducts> findAll();

}
