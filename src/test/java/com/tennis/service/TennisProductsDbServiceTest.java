package com.tennis.service;

import com.tennis.domain.TennisProducts;
import com.tennis.repository.TennisProductsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TennisProductsDbServiceTest {
    @InjectMocks
    private TennisProductsDbService tennisProductsDbService;

    @Mock
    private TennisProductsRepository tennisProductsRepository;

    private static final String DESCRIPTION = "Tennis product description";
    private static final String DESCRIPTION2 = "Tennis product description 2";

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetAllTennisProducts() {
        //Given
        List<TennisProducts> tennisProductsList = new ArrayList<>();
        tennisProductsList.add(new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>()));
        tennisProductsList.add(new TennisProducts(2L, "Head racket", DESCRIPTION2, new BigDecimal(580), new ArrayList<>(), new ArrayList<>()));

        when(tennisProductsRepository.findAll()).thenReturn(tennisProductsList);

        //When
        List<TennisProducts> currentTennisProductsList = tennisProductsDbService.getAllTennisProducts();

        //Then
        assertEquals(tennisProductsList, currentTennisProductsList);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetTennisProductById() {
        //Given
        TennisProducts tennisProducts = new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());

        when(tennisProductsRepository.findById(1L)).thenReturn(Optional.of(tennisProducts));

        //When
        Optional<TennisProducts> findTennisProduct = tennisProductsDbService.getTennisProductById(1L);

        //Then
        assertEquals(tennisProducts, findTennisProduct.get());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testSaveTennisProduct() {
        //Given
        TennisProducts tennisProducts = new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());

        when(tennisProductsRepository.save(tennisProducts)).thenReturn(tennisProducts);

        //When
        TennisProducts savedTennisProduct = tennisProductsDbService.saveTennisProduct(tennisProducts);

        //Then
        assertEquals(tennisProducts, savedTennisProduct);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteTennisProduct() {
        //Given
        TennisProducts tennisProducts = new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());
        tennisProductsDbService.saveTennisProduct(tennisProducts);

        //When
        tennisProductsDbService.deleteTennisProductById(1L);

        //Then
        Mockito.verify(tennisProductsRepository).deleteById(1L);
    }
}
