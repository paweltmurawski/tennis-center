package com.tennis.controller;

import com.tennis.controller.exceptions.TennisCenterUsersNotFoundException;
import com.tennis.domain.TennisCenterUsers;
import com.tennis.dto.TennisCenterUsersDto;
import com.tennis.mapper.TennisCenterUsersMapper;
import com.tennis.service.TennisCenterUsersDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RequestMapping
@RestController(value = "/v1")
public class TennisCenterUsersController {
    @Autowired
    private TennisCenterUsersDbService tennisCenterUsersDbService;
    @Autowired
    private TennisCenterUsersMapper tennisCenterUsersMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<TennisCenterUsersDto> getTennisCenterUsers() {
        return tennisCenterUsersMapper.mapToTennisCenterUsersDtoList(tennisCenterUsersDbService.getAllTennisCenterUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public TennisCenterUsersDto getTennisCenterUser(@PathVariable Long userId) throws TennisCenterUsersNotFoundException {
        return tennisCenterUsersMapper.mapToTennisCenterUsersDto(tennisCenterUsersDbService.getTennisCenterUserById(userId).orElseThrow(TennisCenterUsersNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public void createTennisCenterUser(@RequestBody TennisCenterUsersDto tennisCenterUsersDto) {
        tennisCenterUsersDbService.saveTennisCenterUser(tennisCenterUsersMapper.mapToTennisCenterUsers(tennisCenterUsersDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public TennisCenterUsersDto updateTennisCenterUser(@RequestBody TennisCenterUsersDto tennisCenterUsersDto) {
        return tennisCenterUsersMapper.mapToTennisCenterUsersDto(tennisCenterUsersDbService.saveTennisCenterUser(tennisCenterUsersMapper.mapToTennisCenterUsers(tennisCenterUsersDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteTennisCenterUser(@PathVariable Long userId) {
        tennisCenterUsersDbService.deleteTennisCenterUserById(userId);
    }
}
