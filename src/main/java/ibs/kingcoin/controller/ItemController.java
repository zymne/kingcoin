package ibs.kingcoin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ibs.kingcoin.dao.ItemRepository;
import ibs.kingcoin.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(produces = "application/json", value = "/items")
    public @ResponseBody String listItems() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Iterable<Item> items = itemRepository.findAll();

        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(items);

        return result;
    }

    @CrossOrigin
    @GetMapping("/corscheck")
    public @ResponseBody String checkCors() {
        return "CORS is enabled.";
    }
}
