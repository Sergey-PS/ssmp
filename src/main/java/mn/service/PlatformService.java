package mn.service;

import mn.api.repo.PlatformRepository;
import mn.api.repo.PlatformRepositoryImpl;
import mn.api.response.CityApi;
import mn.api.response.CountryApi;
import mn.api.response.PlatformLanguageApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatformService {

    private PlatformRepository platformRepository;

    public PlatformService() {
        this.platformRepository = new PlatformRepositoryImpl();;
    }

    public List<PlatformLanguageApi> getLanguages(String language,  int offset, int itemPerPage) {
        // language, offset, itemPerPage - will be used in queries
        return platformRepository.findByLanguage(language, offset, itemPerPage);
    }

    public int getTotalLanguage() {
        return platformRepository.getTotalLanguage();
    }

    public List<CityApi> getCities(int countryId, String city,  int offset, int itemPerPage) {
        // countryId, city, offset, itemPerPage - will be used in queries
        return platformRepository.findByCities(countryId, city, offset, itemPerPage);
    }

    public int getTotalCities() {
        return platformRepository.getTotalCities();
    }

    public List<CountryApi> getCountries(String country, int offset, int itemPerPage) {
        // country, offset, itemPerPage - will be used in queries
        return platformRepository.findByCountries(country, offset, itemPerPage);
    }

    public int getTotalCountries() {
        return platformRepository.getTotalCountries();
    }

}
