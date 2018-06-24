package ibs.kingcoin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

@Controller
public class UploadController {

    @CrossOrigin
    @PostMapping("/upload")
    public @ResponseBody String upload(@RequestParam("name") String filename, @RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {

        Long copied = 0L;
        File uploadFolder = new File("images");
        if(!uploadFolder.isDirectory())
            uploadFolder.mkdir();
        Path path = Paths.get(uploadFolder.getPath(), filename);

        try(InputStream file = multipartFile.getInputStream()) {
            copied = Files.copy(file, path, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException e) {

        }
        System.out.println(copied);
        return "OK";
    }

}
