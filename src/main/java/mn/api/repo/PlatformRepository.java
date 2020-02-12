package mn.api.repo;

import mn.api.response.CityApi;
import mn.api.response.CountryApi;
import mn.api.response.PlatformLanguageApi;

import java.util.List;

public interface PlatformRepository {
    List<PlatformLanguageApi> findByLanguage(String language, int offset, int itemPerPage);

    List<CityApi> findByCities(int countryId, String city, int offset, int itemPerPage);

    List<CountryApi> findByCountries(String country, int offset, int itemPerPage);

    int getTotalLanguage();

    int getTotalCities();

    int getTotalCountries();
}
