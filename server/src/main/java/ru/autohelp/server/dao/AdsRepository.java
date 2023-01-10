package ru.autohelp.server.dao;

import org.springframework.data.repository.CrudRepository;
import ru.autohelp.server.models.Ads;

public interface AdsRepository extends CrudRepository<Ads, Long> {

}
