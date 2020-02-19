package mn.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mn.api.response.CityApi;
import mn.api.response.CountryApi;
import mn.api.response.PlatformLanguageApi;
import mn.api.response.ResponsePlatformApi;
import mn.domain.City;
import mn.domain.Country;
import mn.domain.Language;
import mn.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/platform/")
@ResponseBody
public class PlatformController {


    private PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping("languages")
    public ResponsePlatformApi getLanguages(@RequestParam String language,
                                            @RequestParam(defaultValue = "0") int offset,
                                            @RequestParam(defaultValue = "20") int itemPerPage) {
        List<Language> listLanguage = platformService.getLanguages(language, offset, itemPerPage);
        int total = 4; //platformService.getTotalLanguage();
        return new ResponsePlatformApi("done", total, offset, itemPerPage, listLanguage);
        //return new ResponseEntity(a, HttpStatus.OK);
    }

    @GetMapping("countries")
    public ResponsePlatformApi getCountries(@RequestParam String country,
                                            @RequestParam(defaultValue = "0") int offset,
                                            @RequestParam(defaultValue = "20") int itemPerPage) {
        List<Country> listCountry = platformService.getCountries(country, offset, itemPerPage);
        int total = 4; //platformService.getTotalCountries();
        return new ResponsePlatformApi("done", total, offset, itemPerPage, listCountry);
    }

    @GetMapping("cities")
    public ResponsePlatformApi getCities(@RequestParam int countryId,
                                         @RequestParam String city,
                                         @RequestParam(defaultValue = "0") int offset,
                                         @RequestParam(defaultValue = "20") int itemPerPage) {
        List<City> listCity = platformService.getCities(countryId, city, offset, itemPerPage);
        int total = 4; //platformService.getTotalCities();
        return new ResponsePlatformApi("done", total, offset, itemPerPage, listCity);
    }

}
