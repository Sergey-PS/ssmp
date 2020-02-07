package mn.controller;

import mn.api.response.CityApi;
import mn.api.response.CountryApi;
import mn.api.response.PlatformLanguageApi;
import mn.api.response.ResponsePlatformApi;
import mn.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/platform/")

public class PlatformController {

    private PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping("languages")
    public ResponseEntity<ResponsePlatformApi> getLanguages(@RequestParam String language,
                                                            @RequestParam(defaultValue = "0") int offset,
                                                            @RequestParam(defaultValue = "20") int itemPerPage)
    {
        List<PlatformLanguageApi> listLanguage = platformService.getLanguages(language, offset, itemPerPage);
        int total = platformService.getTotalLanguage();
        ResponsePlatformApi platform = new ResponsePlatformApi("done",new Date().getTime(), total, offset, itemPerPage, listLanguage);
        return new ResponseEntity<> (platform , HttpStatus.OK);
    }

    @GetMapping("countries")
    public ResponseEntity<ResponsePlatformApi> getCountries(@RequestParam String country,
                                                            @RequestParam(defaultValue = "0") int offset,
                                                            @RequestParam(defaultValue = "20") int itemPerPage)
    {
        List<CountryApi> listCountry = platformService.getCountries(country, offset, itemPerPage);
        int total = platformService.getTotalCountries();
        ResponsePlatformApi platform = new ResponsePlatformApi("done",new Date().getTime(), total, offset, itemPerPage, listCountry);
        return new ResponseEntity<> (platform , HttpStatus.OK);
    }

    @GetMapping("cities")
    public ResponseEntity<ResponsePlatformApi> getCities(@RequestParam int countryId,
                                                         @RequestParam String city,
                                                         @RequestParam(defaultValue = "0") int offset,
                                                         @RequestParam(defaultValue = "20") int itemPerPage)
    {
        List<CityApi> listCity = platformService.getCities(countryId, city, offset, itemPerPage);
        int total = platformService.getTotalCities();
        ResponsePlatformApi platform = new ResponsePlatformApi("done",new Date().getTime(), total, offset, itemPerPage, listCity);
        return new ResponseEntity<> (platform , HttpStatus.OK);
    }

}
