package com.tennis.service;

import com.tennis.domain.TennisProducts;
import com.tennis.repository.TennisProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TennisProductsDbService {
    @Autowired
    private TennisProductsRepository tennisProductsRepository;

    public List<TennisProducts> getAllTennisProducts() {
        return tennisProductsRepository.findAll();
    }


}
