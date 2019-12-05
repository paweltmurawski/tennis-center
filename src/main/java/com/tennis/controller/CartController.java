package com.tennis.controller;

import com.tennis.controller.exceptions.CartNotFoundException;
import com.tennis.dto.CartDto;
import com.tennis.mapper.CartMapper;
import com.tennis.service.CartDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1")
public class CartController {
    @Autowired
    private CartDbService cartDbService;
    @Autowired
    private CartMapper cartMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/carts")
    public List<CartDto> getCarts() {
        return cartMapper.mapToCartDtoList(cartDbService.getAllCarts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/carts/{cartId}")
    public CartDto getCart(@PathVariable Long cartId) throws CartNotFoundException {
        return cartMapper.mapToCartDto(cartDbService.getCartById(cartId).orElseThrow(CartNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/carts", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        cartDbService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/carts")
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return cartMapper.mapToCartDto(cartDbService.saveCart(cartMapper.mapToCart(cartDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/carts/{cartId}")
    public void deleteCart(@PathVariable Long cartId) {
        cartDbService.deleteCartById(cartId);
    }
}
