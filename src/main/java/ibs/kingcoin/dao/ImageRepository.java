package ibs.kingcoin.dao;

import ibs.kingcoin.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
