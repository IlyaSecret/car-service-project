package ru.autohelp.server.dao;

import org.springframework.data.repository.CrudRepository;
import ru.autohelp.server.models.History;

public interface HistoryRepository extends CrudRepository<History, Integer> {

}
