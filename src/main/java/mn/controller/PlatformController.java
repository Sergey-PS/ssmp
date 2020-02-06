package mn.controller;

import mn.api.response.CityApi;
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
//@RequestMapping("/api/v1/platform")

public class PlatformController {

    private PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping("api/v1/platform/languages")
    public ResponseEntity<ResponsePlatformApi> getLanguages(@RequestParam String language,
                                                            @RequestParam(defaultValue = "0") int offset,
                                                            @RequestParam(defaultValue = "20") int itemPerPage)
    {
        ResponsePlatformApi platform = new ResponsePlatformApi("error",new Date().getTime(),0,1,30,platformService.getLanguages());
        return new ResponseEntity<ResponsePlatformApi> (platform , HttpStatus.OK);
    }

}
