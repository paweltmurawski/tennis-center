package com.tennis.service;

import com.tennis.domain.Cart;
import com.tennis.domain.Payment;
import com.tennis.domain.TennisCenterUsers;
import com.tennis.repository.CartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartDbServiceTest {
    @InjectMocks
    private CartDbService cartDbService;
    @Mock
    private CartRepository cartRepository;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetAllCarts() {
        //Given
        List<Cart> cartList = new ArrayList<>();
        cartList.add(new Cart(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>())));
        cartList.add(new Cart(2L, Payment.TRANSFER, new ArrayList<>(), new TennisCenterUsers(2L, "Thomas W", "secondTestMail@gmail.com", "Brunatna 14", "746395739", new ArrayList<>())));

        when(cartRepository.findAll()).thenReturn(cartList);

        //When
        List<Cart> currentCartList = cartDbService.getAllCarts();

        //Then
        assertEquals(cartList, currentCartList);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetCartById() {
        //Given
        Cart cart = new Cart(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));

        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));

        //When
        Optional<Cart> findCart = cartDbService.getCartById(1L);

        //Then
        assertEquals(cart, findCart.get());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testSaveCart() {
        //Given
        Cart cart = new Cart(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));

        when(cartRepository.save(cart)).thenReturn(cart);

        //When
        Cart savedCart = cartDbService.saveCart(cart);

        //Then
        assertEquals(cart, savedCart);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteCart() {
        //Given
        Cart cart = new Cart(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));
        cartDbService.saveCart(cart);

        //When
        cartDbService.deleteCartById(1L);

        //Then
        Mockito.verify(cartRepository).deleteById(1L);
    }
}
