package ibs.kingcoin.dao;

import ibs.kingcoin.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, String> {
    Country findByName(String name);
}
