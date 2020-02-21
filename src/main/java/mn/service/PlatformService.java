package mn.service;

import lombok.extern.slf4j.Slf4j;
import mn.domain.City;
import mn.domain.Country;
import mn.domain.Language;
import mn.repository.CityRepository;
import mn.repository.CountryRepository;
import mn.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        log.info("Search for a language containing '{}' [Offset : {}; ItemPerPage : {}]",language,offset,itemPerPage);
        return languageRepository.findLanguageByName(language, offset, itemPerPage);
    }

    public int getLanguageTotal() {
        return languageRepository.getTotalLanguage();
    }

    public List<City> getCities(int countryId, String city, int offset, int itemPerPage) {
        log.info("Search for a city containing '{}' [Offset : {}; ItemPerPage : {}]",city,offset,itemPerPage);
        return cityRepository.findCityByName(countryId, city, offset, itemPerPage);
    }

    public int getTotalCities(int countryId) {
            return cityRepository.getCityTotal(countryId);
    }

    public List<Country> getCountries(String country, int offset, int itemPerPage) {
        log.info("Search for a country containing '{}' [Offset : {}; ItemPerPage : {}]",country,offset,itemPerPage);
        return countryRepository.findLanguageByName(country, offset, itemPerPage);
    }

    public int getCountryTotal() {
        return countryRepository.getCountryTotal();
    }

}
