package mn.service;

import mn.api.response.CityApi;
import mn.api.response.CountryApi;
import mn.api.response.PlatformLanguageApi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatformService {

    private static final List<PlatformLanguageApi> listLanguage = new ArrayList<>();
    private static final List<CityApi> listCity = new ArrayList<>();
    private static final List<CountryApi> listCountry = new ArrayList<>();

    static {
        listLanguage.add(new PlatformLanguageApi(1,"Russian"));
        listLanguage.add(new PlatformLanguageApi(2,"English"));
        listLanguage.add(new PlatformLanguageApi(3,"German"));

        listCountry.add(new CountryApi(1, "Russian"));
        listCountry.add(new CountryApi(2, "English"));
        listCountry.add(new CountryApi(1, "Germany"));

        listCity.add(new CityApi(1,"Moscow"));
        listCity.add(new CityApi(2,"London"));
        listCity.add(new CityApi(3,"Berlin"));
    }

    public List<PlatformLanguageApi> getLanguages(String language, int total, int itemPerPage) {
        // language, total, itemPerPage - will be used in queries
        return listLanguage;
    }

    public int getTotalLanguage() {
        return listLanguage.size();
    }

    public List<CityApi> getCities(int countryId, String city, int total, int itemPerPage) {
        // countryId, city, total, itemPerPage - will be used in queries
        return listCity;
    }

    public int getTotalCities() {
        return listCity.size();
    }

    public List<CountryApi> getCountries(String country, int offset, int itemPerPage) {
        // country, total, itemPerPage - will be used in queries
        return listCountry;
    }

    public int getTotalCountries() {
        return listCountry.size();
    }

}
