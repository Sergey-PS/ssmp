package mn.service;

import mn.domain.City;
import mn.domain.Country;
import mn.domain.Language;
import mn.repository.CityRepository;
import mn.repository.CountryRepository;
import mn.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    private LanguageRepository languageRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    @Autowired
    public PlatformService(CityRepository cityRepository, CountryRepository countryRepository, LanguageRepository languageRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.languageRepository = languageRepository;
    }

    public List<Language> getLanguages(String language, int offset, int itemPerPage) {
        // language, offset, itemPerPage - will be used in queries
//        return listLanguage.stream()
//                .filter(s -> s.getTitle().toLowerCase().indexOf(language) != -1)
//                .skip(offset)
//                .limit(itemPerPage)
//                .collect(Collectors.toList());

        return languageRepository.findLanguageByName(language, offset, itemPerPage);
    }

    public int getLanguageTotal() {
        return languageRepository.getTotalLanguage();
    }

//    public int getTotalLanguage() {
//        return listLanguage.size();
//    }

    public List<City> getCities(int countryId, String city, int offset, int itemPerPage) {
        // countryId, city, offset, itemPerPage - will be used in queries
//        return listCity.stream()
//                .filter(s -> s.getTitle().toLowerCase().indexOf(city) != -1)
//                .skip(offset)
//                .limit(itemPerPage)
//                .collect(Collectors.toList());
        return cityRepository.findCityByName(countryId, city, offset, itemPerPage);
    }

    public int getTotalCities(int countryId) {
            return cityRepository.getCityTotal(countryId);
    }

    public List<Country> getCountries(String country, int offset, int itemPerPage) {
        // country, offset, itemPerPage - will be used in queries
//        return listCountry.stream()
//                .filter(s -> s.getTitle().toLowerCase().indexOf(country) != -1)
//                .skip(offset)
//                .limit(itemPerPage)
//                .collect(Collectors.toList());
        return countryRepository.findLanguageByName(country, offset, itemPerPage);
    }

    public int getCountryTotal() {
        return countryRepository.getCountryTotal();
    }

//    public int getTotalCountries() {
//        return listCountry.size();
//    }

}
