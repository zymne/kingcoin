package ibs.kingcoin.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImageController {

    @CrossOrigin
    @GetMapping("images/{filename:.+}")
    public @ResponseBody ResponseEntity<Resource> serveImage(@PathVariable String filename) {
        Resource file = null;

        //TODO: Replace this with FileSystemStorageService
        try {
            File folder = new File("images");
            Path path = Paths.get(folder.getPath());

            Path filePath = path.resolve(filename);

            URI uri = filePath.toUri();
            Resource resource = new UrlResource(uri);
            if (resource.exists() || resource.isReadable()) {
                file = resource;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //TODO: replace this with more simple way to generate proper content, also consider supporting of png
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE,"image/jpeg")
                .body(file);
    }
}
