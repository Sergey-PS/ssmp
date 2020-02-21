package mn.repository;

import mn.domain.Country;
import mn.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value = "SELECT * FROM countries WHERE country LIKE %:country% LIMIT :itemPerPage OFFSET :offset", nativeQuery = true)
    List<Country> findLanguageByName(@Param("country") String country,
                                      @Param("offset") int offset,
                                      @Param("itemPerPage") int itemPerPage);

    @Query(value = "SELECT count(*) FROM countries", nativeQuery = true)
    int getCountryTotal();
}
