package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
