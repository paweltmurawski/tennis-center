package com.tennis.mapper;

import com.tennis.domain.TennisProducts;
import com.tennis.dto.TennisProductsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TennisProductsMapper {
    public TennisProducts mapToTennisProducts(final TennisProductsDto tennisProductsDto) {
        return new TennisProducts(
                tennisProductsDto.getId(),
                tennisProductsDto.getProductName(),
                tennisProductsDto.getDescription(),
                tennisProductsDto.getProductPrice(),
                tennisProductsDto.getUsersOrders(),
                tennisProductsDto.getCarts()
        );
    }

    public TennisProductsDto mapToTennisProductsDto(final TennisProducts tennisProducts) {
        return new TennisProductsDto(
                tennisProducts.getId(),
                tennisProducts.getProductName(),
                tennisProducts.getDescription(),
                tennisProducts.getProductPrice(),
                tennisProducts.getUsersOrders(),
                tennisProducts.getCarts()
        );
    }

    public List<TennisProductsDto> mapToTennisProductsDtoList(final List<TennisProducts> tennisProductsList) {
        return tennisProductsList.stream()
                .map(t -> new TennisProductsDto(t.getId(), t.getProductName(), t.getDescription(), t.getProductPrice(), t.getUsersOrders(), t.getCarts()))
                .collect(Collectors.toList());
    }
}
