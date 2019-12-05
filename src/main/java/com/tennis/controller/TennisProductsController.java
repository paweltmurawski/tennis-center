package com.tennis.controller;

import com.tennis.controller.exceptions.TennisProductsNotFoundException;
import com.tennis.dto.TennisProductsDto;
import com.tennis.mapper.TennisProductsMapper;
import com.tennis.service.TennisProductsDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1")
public class TennisProductsController {
    @Autowired
    private TennisProductsDbService tennisProductsDbService;
    @Autowired
    private TennisProductsMapper tennisProductsMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public List<TennisProductsDto> getTennisProducts() {
        return tennisProductsMapper.mapToTennisProductsDtoList(tennisProductsDbService.getAllTennisProducts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "products/{productId}")
    public TennisProductsDto getTennisProduct(@PathVariable Long productId) throws TennisProductsNotFoundException {
        return tennisProductsMapper.mapToTennisProductsDto(tennisProductsDbService.getTennisProductById(productId).orElseThrow(TennisProductsNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products", consumes = APPLICATION_JSON_VALUE)
    public void createTennisProduct(@RequestBody TennisProductsDto tennisProductsDto) {
        tennisProductsDbService.saveTennisProduct(tennisProductsMapper.mapToTennisProducts(tennisProductsDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products")
    public TennisProductsDto updateTennisProduct(@RequestBody TennisProductsDto tennisProductsDto) {
        return tennisProductsMapper.mapToTennisProductsDto(tennisProductsDbService.saveTennisProduct(tennisProductsMapper.mapToTennisProducts(tennisProductsDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{productId}")
    public void deleteTennisProduct(@PathVariable Long productId) {
        tennisProductsDbService.deleteTennisProductById(productId);
    }
}
