package ibs.kingcoin;

import com.fasterxml.jackson.databind.ObjectMapper;
import ibs.kingcoin.dao.CategoryRepository;
import ibs.kingcoin.dao.CountryRepository;
import ibs.kingcoin.dao.ItemRepository;
import ibs.kingcoin.model.Category;
import ibs.kingcoin.model.Country;
import ibs.kingcoin.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;


/*Сканирует классы из того же пакета на наличие тестовых конфигураций*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class DataStorageTest {


    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CountryRepository countryRepository;

    @Test
    public void createCountries() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("country.json");

        TreeMap<String, String> countris = new TreeMap<>();
        countris = new ObjectMapper().readValue(inputStream, countris.getClass());
        for(String key : countris.keySet()) {
            String code = key;
            String name = countris.get(key);
            Country country = new Country(name, code);
            countryRepository.save(country);
        }

        System.out.println("Countries created in the db: " + countris.keySet().size());
    }

    @Test
    public void generateTestData() {

        Calendar calendar = Calendar.getInstance();

        Category cat = new Category("Банкноты");
        cat = categoryRepository.save(cat);

        Category cat1 = new Category("Монеты");
        categoryRepository.save(cat1);

        Category cat2 = new Category("Наборы");
        categoryRepository.save(cat2);

//        Country country = new Country("Russia", "RU");
//        country = countryRepository.save(country);

        Optional<Country> ru = countryRepository.findById("RU");
        Country country = ru.get();

        calendar.set(2018, 05, 22);
        Item item = new Item();
        item.setTitle("Памятная банкнота Банка России образца 2018 года номиналом 100 рублей");
        item.setCategory(cat);
        item.setCountry(country);
        item.setPublished(true);
        item.setPrice(120);
        item.setIssueYear(calendar.getTime());
        itemRepository.save(item);

        calendar.set(2017, 10, 12);
        Item item1 = new Item();
        item1.setTitle("Банкнота Банка России образца 2017 года номиналом 200 рублей");
        item1.setCategory(cat);
        item1.setCountry(country);
        item1.setPublished(true);
        item1.setPrice(250);
        item1.setIssueYear(calendar.getTime());
        itemRepository.save(item1);

        calendar.set(2011, 9, 6);
        Item item2 = new Item();
        item2.setTitle("Банкнота Банка России образца 1997 года номиналом 500 рублей модификации 2010 года");
        item2.setCategory(cat);
        item2.setCountry(country);
        item2.setPublished(true);
        item2.setPrice(600);
        item2.setIssueYear(calendar.getTime());
        itemRepository.save(item2);
    }
}
