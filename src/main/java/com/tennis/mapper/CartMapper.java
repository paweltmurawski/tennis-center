package com.tennis.mapper;

import com.tennis.domain.Cart;
import com.tennis.dto.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getPayment(),
                cartDto.getTennisProducts(),
                cartDto.getTennisCenterUsers()
        );
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getPayment(),
                cart.getTennisProducts(),
                cart.getTennisCenterUsers()
        );
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(t -> new CartDto(t.getId(), t.getPayment(), t.getTennisProducts(), t.getTennisCenterUsers()))
                .collect(Collectors.toList());
    }
}
