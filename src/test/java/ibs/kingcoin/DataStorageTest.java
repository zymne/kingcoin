package ibs.kingcoin;

import ibs.kingcoin.dao.ItemRepository;
import ibs.kingcoin.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

/*Сканирует классы из того же пакета на наличие тестовых конфигураций*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class DataStorageTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void generateTestData() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 01, 01);

        Item item = new Item();
        item.setTitle("100 rubles");
        item.setCategory("banknotes");
        item.setCountry("Russia");
        item.setPublished(true);
        item.setPrice(120);
        item.setIssueYear(calendar.getTime());
        itemRepository.save(item);

        Item item1 = new Item();
        item1.setTitle("200 rubles");
        item1.setCategory("banknotes");
        item1.setCountry("Russia");
        item1.setPublished(true);
        item1.setPrice(250);
        item1.setIssueYear(calendar.getTime());
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setTitle("500 rubles");
        item2.setCategory("banknotes");
        item2.setCountry("Russia");
        item2.setPublished(true);
        item2.setPrice(600);
        item2.setIssueYear(calendar.getTime());
        itemRepository.save(item2);
    }
}
