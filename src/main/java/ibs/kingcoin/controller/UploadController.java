package ibs.kingcoin.controller;

import ibs.kingcoin.dao.ItemRepository;
import ibs.kingcoin.model.Image;
import ibs.kingcoin.model.Item;
import ibs.kingcoin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.Optional;

@Controller
public class UploadController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ItemRepository itemRepository;

    @CrossOrigin
    @PostMapping("/upload/{id}")
    public @ResponseBody String upload(@PathVariable Long id, @RequestParam("name") String filename, @RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {

        Long copiedBytes = 0L;

        Item item = itemRepository.findById(id).get();

        File uploadFolder = new File("images");
        if(!uploadFolder.isDirectory())
            uploadFolder.mkdir();
        Path path = Paths.get(uploadFolder.getPath(), filename);

        try(InputStream file = multipartFile.getInputStream()) {

            copiedBytes = Files.copy(file, path, StandardCopyOption.REPLACE_EXISTING);

            if(copiedBytes > 0 && item != null) {
                Image image = new Image();
                image.setItem(item);
                image.setUrl(path.toString());
                imageService.addImage(image);
            }

        } catch(IOException e) {

        }
        System.out.println(copiedBytes);
        return "OK";
    }

}
