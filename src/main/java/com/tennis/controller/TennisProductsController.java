package com.tennis.controller;

import com.tennis.dto.TennisProductsDto;
import com.tennis.mapper.TennisProductsMapper;
import com.tennis.service.TennisProductsDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/tennisProducts")
public class TennisProductsController {
    @Autowired
    private TennisProductsDbService tennisProductsDbService;
    @Autowired
    private TennisProductsMapper tennisProductsMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTennisProducts")
    public List<TennisProductsDto> getTennisProducts() {
        return tennisProductsMapper.mapToTennisProductsDtoList(tennisProductsDbService.getAllTennisProducts());
    }




}
