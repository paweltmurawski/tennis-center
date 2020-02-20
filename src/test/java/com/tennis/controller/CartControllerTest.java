
package com.tennis.controller;

import com.google.gson.Gson;
import com.tennis.domain.Cart;
import com.tennis.domain.Payment;
import com.tennis.domain.TennisCenterUsers;
import com.tennis.domain.TennisProducts;
import com.tennis.dto.CartDto;
import com.tennis.dto.TennisCenterUsersDto;
import com.tennis.dto.TennisProductsDto;
import com.tennis.mapper.CartMapper;
import com.tennis.service.CartDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CartMapper cartMapper;
    @MockBean
    private CartDbService cartDbService;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetCarts() throws Exception {
        //Given
        List<CartDto> cartList = new ArrayList<>();
        cartList.add(new CartDto(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>())));
        cartList.add(new CartDto(2L, Payment.TRANSFER, new ArrayList<>(), new TennisCenterUsers(2L, "Thomas W", "secondTestMail@gmail.com", "Brunatna 14", "746395739", new ArrayList<>())));

        when(cartMapper.mapToCartDtoList(cartDbService.getAllCarts())).thenReturn(cartList);

        //When & Then
        mockMvc.perform(get("/v1/carts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].payment", is(Payment.CASH)))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].payment", is(Payment.TRANSFER)));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testGetCart() throws Exception {
        Cart cart = new Cart(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul M", "testMail@gmail.com", "Liliowa 8", "123456789", new ArrayList<>()));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void testCreateCart() throws Exception {
        //Given
        CartDto cartDto = new CartDto(1L, Payment.CASH, new ArrayList<>(), new TennisCenterUsers(1L, "Paul", "testEmail@mail",  "Lipnowska 4", "123456789", new ArrayList<>()));

        Gson gson = new Gson();
        String jsonContent = gson.toJson(cartDto);

        //When & Then
        mockMvc.perform(post("/v1/carts").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

    }
}
