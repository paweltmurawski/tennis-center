package com.tennis.controller;

import com.tennis.controller.exceptions.UsersOrdersNotFoundException;
import com.tennis.dto.UsersOrdersDto;
import com.tennis.mapper.UsersOrdersMapper;
import com.tennis.service.UsersOrdersDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1")
public class UsersOrdersController {
    @Autowired
    private UsersOrdersDbService usersOrdersDbService;
    @Autowired
    private UsersOrdersMapper usersOrdersMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<UsersOrdersDto> getUsersOrders() {
        return usersOrdersMapper.mapToUsersOrdersDtoList(usersOrdersDbService.getAllUsersOrders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders/{orderId")
    public UsersOrdersDto getUserOrder(@PathVariable Long orderId) throws UsersOrdersNotFoundException {
        return usersOrdersMapper.mapToUsersOrdersDto(usersOrdersDbService.getUserOrderById(orderId).orElseThrow(UsersOrdersNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders", consumes = APPLICATION_JSON_VALUE)
    public void createUserOrder(@RequestBody UsersOrdersDto usersOrdersDto) {
        usersOrdersDbService.saveUserOrder(usersOrdersMapper.mapToUsersOrders(usersOrdersDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders")
    public UsersOrdersDto updateUserOrder(@RequestBody UsersOrdersDto usersOrdersDto) {
        return usersOrdersMapper.mapToUsersOrdersDto(usersOrdersDbService.saveUserOrder(usersOrdersMapper.mapToUsersOrders(usersOrdersDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{orderId}")
    public void deleteUserOrder(@PathVariable Long orderId) {
        usersOrdersDbService.deleteUserOrderById(orderId);
    }
}
