package nl.hsleiden.svdj8.repository;

import nl.hsleiden.svdj8.models.tables.Grant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrantRepository extends JpaRepository<Grant, Long> {
//    List<Grant> findByKeywords(Keyword keywords);
   }