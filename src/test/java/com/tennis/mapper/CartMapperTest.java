package com.tennis.mapper;

import com.tennis.domain.Cart;
import com.tennis.domain.Payment;
import com.tennis.domain.TennisCenterUsers;
import com.tennis.dto.CartDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMapperTest {
    @Autowired
    private CartMapper cartMapper;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToCart() {
        //Given
        CartDto cartDto = new CartDto(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));

        //When
        Cart cart = cartMapper.mapToCart(cartDto);

        //Then
        assertEquals(1L, cart.getId(), 0);
        assertEquals(Payment.CASH, cart.getPayment());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToCartDto() {
        //Given
        Cart cart = new Cart(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));

        //When
        CartDto cartDto = cartMapper.mapToCartDto(cart);

        //Then
        assertEquals(1L, cartDto.getId(), 0);
        assertEquals(Payment.CASH, cartDto.getPayment());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testMapToCartDtoList() {
        //Given
        List<Cart> cartList = new ArrayList<>();
        cartList.add(new Cart(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>())));
        cartList.add(new Cart(2L, Payment.TRANSFER, new ArrayList<>(), new TennisCenterUsers(2L, "Thomas W", "secondTestMail@gmail.com", "Brunatna 14", "746395739", new ArrayList<>())));

        //When
        List<CartDto> cartListDto = cartMapper.mapToCartDtoList(cartList);

        //Then
        assertEquals(1L, cartListDto.get(0).getId(), 0);
        assertEquals(Payment.CASH, cartListDto.get(0).getPayment());
        assertEquals(2L, cartListDto.get(1).getId(), 0);
        assertEquals(Payment.TRANSFER, cartListDto.get(1).getPayment());
    }
}
