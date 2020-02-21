package mn.repository;

import mn.api.response.CityApi;
import mn.domain.City;
import mn.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query(value = "SELECT * FROM cities WHERE country_id = :countryId and city LIKE %:city% LIMIT :itemPerPage OFFSET :offset", nativeQuery = true)
    List<City> findCityByName(@Param("countryId") int countryId,
                                 @Param("city") String city,
                                 @Param("offset") int offset,
                                 @Param("itemPerPage") int itemPerPage);

    @Query(value = "SELECT count(*) FROM cities WHERE country_id = :countryId", nativeQuery = true)
    int getCityTotal(@Param("countryId") int countryId);

}
