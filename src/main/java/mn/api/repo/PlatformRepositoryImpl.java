package mn.api.repo;

import mn.api.response.CityApi;
import mn.api.response.CountryApi;
import mn.api.response.PlatformLanguageApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlatformRepositoryImpl implements PlatformRepository {

    private static final List<PlatformLanguageApi> listLanguage = new ArrayList<>();
    private static final List<CityApi> listCity = new ArrayList<>();
    private static final List<CountryApi> listCountry = new ArrayList<>();

    static {
        listLanguage.add(new PlatformLanguageApi(1, "Russian"));
        listLanguage.add(new PlatformLanguageApi(2, "English"));
        listLanguage.add(new PlatformLanguageApi(3, "German"));
        listLanguage.add(new PlatformLanguageApi(4, "France"));

        listCountry.add(new CountryApi(1, "Russian"));
        listCountry.add(new CountryApi(2, "English"));
        listCountry.add(new CountryApi(3, "Germany"));
        listCountry.add(new CountryApi(4, "France"));

        listCity.add(new CityApi(1, "Moscow"));
        listCity.add(new CityApi(2, "London"));
        listCity.add(new CityApi(3, "Berlin"));
        listCity.add(new CityApi(4, "Paris"));
    }

    @Override
    public List<PlatformLanguageApi> findByLanguage(String language, int offset, int itemPerPage) {
        return listLanguage.stream()
                .filter(s -> s.getTitle().toLowerCase().indexOf(language) != -1)
                .skip(offset)
                .limit(itemPerPage)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityApi> findByCities(int countryId, String city, int offset, int itemPerPage) {
        return listCity.stream()
                .filter(s -> s.getTitle().toLowerCase().indexOf(city) != -1)
                .skip(offset)
                .limit(itemPerPage)
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryApi> findByCountries(String country, int offset, int itemPerPage) {
        return listCountry.stream()
                .filter(s -> s.getTitle().toLowerCase().indexOf(country) != -1)
                .skip(offset)
                .limit(itemPerPage)
                .collect(Collectors.toList());
    }

    @Override
    public int getTotalLanguage() {
        return listLanguage.size();
    }

    @Override
    public int getTotalCities() {
        return listCity.size();
    }

    @Override
    public int getTotalCountries() {
        return listCountry.size();
    }
}
