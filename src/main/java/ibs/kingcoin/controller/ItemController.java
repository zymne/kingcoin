package ibs.kingcoin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ibs.kingcoin.dao.ItemRepository;
import ibs.kingcoin.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

@Controller
//TODO: Remove cross origin after debugging
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody String listItems() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Iterable<Item> items = itemRepository.findAll();

        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(items);

        return result;
    }

    @PostMapping(consumes = "application/json")
    public @ResponseBody Integer create(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        String line = null;
        while((line = reader.readLine()) != null ) {
            System.out.println(line);
        }

        System.out.println("Received an item with title:" + req.getReader());
        return 0;
    }

    @CrossOrigin
    @GetMapping("/corscheck")
    public @ResponseBody String checkCors() {
        return "CORS is enabled.";
    }
}
