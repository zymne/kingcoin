package ibs.kingcoin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ibs.kingcoin.dao.CategoryRepository;
import ibs.kingcoin.dao.CountryRepository;
import ibs.kingcoin.dao.ItemRepository;
import ibs.kingcoin.model.Category;
import ibs.kingcoin.model.Country;
import ibs.kingcoin.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;

@RestController
//TODO: Remove cross origin after debugging
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CountryRepository countryRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Item> listItems() throws JsonProcessingException {

        Iterable<Item> items = itemRepository.findAll();

        return items;
    }

    @PostMapping(consumes = "application/json")
    public @ResponseBody Item create(@RequestBody Item item) throws IOException {

        String categoryName = item.getCategory();
        String countryName = item.getCountry();

        Category category = categoryRepository.findByName(categoryName);
        Country country =  countryRepository.findByName(countryName);

        //ResponseBuilder.error().body() or generate Domain Specific Exception
        if(category == null || country == null)
            return null;


        item.setCategory(category);
        item.setCountry(country);

        item = itemRepository.save(item);
        return item;
    }
}
