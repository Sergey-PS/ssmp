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

    public List<PlatformLanguageApi> getLanguages() {
        return listLanguage;
    }

    public List<CityApi> getCities() {
        return listCity;
    }

    public List<CountryApi> getCountries() {
        return listCountry;
    }

}
