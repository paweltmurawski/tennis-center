package com.tennis.repository;

import com.tennis.domain.TennisProducts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TennisProductRepositoryTestSuite {
    @Autowired
    private TennisProductsRepository tennisProductRepository;
    private static final String DESCRIPTION = "Tennis product description";

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testCreateTennisProductRepository() {
        //Given
        TennisProducts tennisProducts = new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());

        //When
        tennisProductRepository.save(tennisProducts);
        int countTennisProducts = tennisProductRepository.findAll().size();

        //Then
        assertEquals(1, countTennisProducts);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testReadTennisProductRepository() {
        //Given
        TennisProducts tennisProducts = new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());

        //When
        tennisProductRepository.save(tennisProducts);
        TennisProducts readTennisProducts = tennisProductRepository.findById(1L).orElse(null);

        //Then
        assertEquals(tennisProducts, readTennisProducts);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testUpdateTennisProductRepository() {
        //Given
        TennisProducts tennisProducts = new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());
        tennisProductRepository.save(tennisProducts);

        //When
        TennisProducts updatedPrice =  new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(550), new ArrayList<>(), new ArrayList<>());
        tennisProductRepository.save(updatedPrice);
        TennisProducts updatedTennisProducts = tennisProductRepository.findById(1L).orElse(null);

        //Then
        assertEquals(updatedPrice, updatedTennisProducts);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteTennisProductRepository() {
        //Given
        TennisProducts tennisProducts = new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());
        tennisProductRepository.save(tennisProducts);

        //When
        tennisProductRepository.deleteById(1L);
        TennisProducts deletedTennisProductRepository = tennisProductRepository.findById(1L).orElse(null);

        //Then
        assertNull(deletedTennisProductRepository);
    }
}