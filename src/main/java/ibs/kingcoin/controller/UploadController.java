package ibs.kingcoin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

    @CrossOrigin
    @PostMapping("/upload")
    public @ResponseBody String upload(@RequestParam("name") String filename, @RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) {

        System.out.println(filename);
        return "OK";
    }

}
