package ibs.kingcoin.dao;

import ibs.kingcoin.model.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
