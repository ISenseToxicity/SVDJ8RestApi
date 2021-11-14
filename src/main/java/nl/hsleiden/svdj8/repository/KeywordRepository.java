package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.Grant;
import nl.hsleiden.svdj8.models.tables.Keyword;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KeywordRepository extends CrudRepository<Keyword, Long> {
    List<Keyword> findByGrand(Grant grand);
}
