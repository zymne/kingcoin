package ibs.kingcoin.controller;

import ibs.kingcoin.dao.CountryRepository;
import ibs.kingcoin.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public @ResponseBody List<String> countries() {

        List<String> names = new ArrayList<>();
        for( Country country : countryRepository.findAll()) {
            if(!country.getName().equalsIgnoreCase("Eurozone"))
                names.add(country.getName());
        }
        Collections.sort(names);
        return names;
    }

}
