package com.tennis.mapper;

import com.tennis.domain.TennisProducts;
import com.tennis.dto.TennisProductsDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TennisProductsMapperTest {
    @Autowired
    private TennisProductsMapper tennisProductsMapper;
    private static final String DESCRIPTION = "Tennis product description";
    private static final String DESCRIPTION2 = "Tennis product description 2";

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToTennisProducts() {
        //Given
        TennisProductsDto tennisProductsDto = new TennisProductsDto(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());

        //When
        TennisProducts tennisProducts = tennisProductsMapper.mapToTennisProducts(tennisProductsDto);

        //Then
        assertEquals(1L, tennisProducts.getId(), 0);
        assertEquals("Babolat racket", tennisProducts.getProductName());
        assertEquals(DESCRIPTION, tennisProducts.getDescription());
        assertEquals(new BigDecimal(650), tennisProducts.getProductPrice());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToTennisProductsDto() {
        //Given
        TennisProducts tennisProducts = new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>());

        //When
        TennisProductsDto tennisProductsDto = tennisProductsMapper.mapToTennisProductsDto(tennisProducts);

        //Then
        assertEquals(1L, tennisProductsDto.getId(), 0);
        assertEquals("Babolat racket", tennisProductsDto.getProductName());
        assertEquals(DESCRIPTION, tennisProductsDto.getDescription());
        assertEquals(new BigDecimal(650), tennisProductsDto.getProductPrice());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToTennisProductsDtoList() {
        //Given
        List<TennisProducts> tennisProductsList = new ArrayList<>();
        tennisProductsList.add(new TennisProducts(1L, "Babolat racket", DESCRIPTION, new BigDecimal(650), new ArrayList<>(), new ArrayList<>()));
        tennisProductsList.add(new TennisProducts(2L, "Head racket", DESCRIPTION2, new BigDecimal(580), new ArrayList<>(), new ArrayList<>()));

        //When
        List<TennisProductsDto> tennisProductsDtoList = tennisProductsMapper.mapToTennisProductsDtoList(tennisProductsList);

        //Then
        assertEquals(1L, tennisProductsDtoList.get(0).getId(), 0);
        assertEquals("Babolat racket", tennisProductsDtoList.get(0).getProductName());
        assertEquals(DESCRIPTION, tennisProductsDtoList.get(0).getDescription());
        assertEquals(new BigDecimal(650), tennisProductsDtoList.get(0).getProductPrice());
        assertEquals(2L, tennisProductsDtoList.get(1).getId(), 0);
        assertEquals("Head racket", tennisProductsDtoList.get(1).getProductName());
        assertEquals(DESCRIPTION2, tennisProductsDtoList.get(1).getDescription());
        assertEquals(new BigDecimal(580), tennisProductsDtoList.get(1).getProductPrice());
    }
}
