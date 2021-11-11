package nl.hsleiden.svdj8.models.tables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface GrantRepository extends JpaRepository<Grant, Long> {
    @Query("select g from Grant g where g.keywords = ?1")
    Collection<Grant> findByKeywords(Keyword keywords);
}