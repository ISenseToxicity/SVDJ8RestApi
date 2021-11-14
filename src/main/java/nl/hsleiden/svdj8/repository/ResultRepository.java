package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.Grant;
import nl.hsleiden.svdj8.models.tables.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {
    List<Result> findByGrant(Grant grant);
}
