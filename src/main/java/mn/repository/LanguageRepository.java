package mn.repository;

import mn.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    @Query(value = "SELECT * FROM language WHERE language LIKE concat('%' + :language + '%')", nativeQuery = true)
    List<Language> findLanguageByName(@Param("language") String language);
}
