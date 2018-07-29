package ibs.kingcoin.service;

import ibs.kingcoin.dao.ImageRepository;
import ibs.kingcoin.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageService {

    @Autowired
    private ImageRepository repository;

    public void addImage(Image image) {
        repository.save(image);
    }

}
