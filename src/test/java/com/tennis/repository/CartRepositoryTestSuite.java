package com.tennis.repository;

import com.tennis.domain.Cart;
import com.tennis.domain.TennisCenterUsers;
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
public class CartRepositoryTestSuite {
    @Autowired
    private CartRepository cartRepository;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testCreateCartRepository() {
        //Given
        Cart cart = new Cart(1, "Babolat racket", new BigDecimal(600), 1, new ArrayList<>(), new TennisCenterUsers(1, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));

        //When
        cartRepository.save(cart);
        int countCarts = cartRepository.findAll().size();

        //Then
        assertEquals(1, countCarts);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testReadCartRepository() {
        //Given
        Cart cart = new Cart(1, "Babolat racket", new BigDecimal(600), 1, new ArrayList<>(), new TennisCenterUsers(1, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));

        //When
        cartRepository.save(cart);
        Cart readCart = cartRepository.findById(1).orElse(null);

        //Then
        assertEquals(cart, readCart);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testUpdateCartRepository() {
        //Given
        Cart cart = new Cart(1, "Babolat racket", new BigDecimal(600), 1, new ArrayList<>(), new TennisCenterUsers(1, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));
        cartRepository.save(cart);

        //When
        Cart updatedProductName = new Cart(1, "Head racket", new BigDecimal(600), 1, new ArrayList<>(), new TennisCenterUsers(1, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));
        cartRepository.save(updatedProductName);
        Cart updatedCart = cartRepository.findById(1).orElse(null);

        //Then
        assertEquals(updatedProductName, updatedCart);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testDeleteCartRepository() {
        //Given
        Cart cart = new Cart(1, "Babolat racket", new BigDecimal(600), 1, new ArrayList<>(), new TennisCenterUsers(1, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));
        cartRepository.save(cart);

        //When
        cartRepository.deleteById(1);
        Cart deletedCart = cartRepository.findById(1).orElse(null);

        //Then
        assertNull(deletedCart);
    }
}
