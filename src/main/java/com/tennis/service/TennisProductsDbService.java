package com.tennis.service;

import com.tennis.domain.TennisProducts;
import com.tennis.repository.TennisProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TennisProductsDbService {
    @Autowired
    private TennisProductsRepository tennisProductsRepository;

    public List<TennisProducts> getAllTennisProducts() {
        return tennisProductsRepository.findAll();
    }

    public Optional<TennisProducts> getTennisProductById(final Long id) {
        return tennisProductsRepository.findById(id);
    }

    public TennisProducts saveTennisProduct(final TennisProducts tennisProducts) {
        return tennisProductsRepository.save(tennisProducts);
    }

    public void deleteTennisProductById(final Long id) {
        tennisProductsRepository.deleteById(id);
    }
}
