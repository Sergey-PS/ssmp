package mn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/platform")


public class PlatformController {


    @GetMapping("/languages")
    public void getLanguages(@RequestParam String language,
                             @RequestParam(defaultValue = "0") int offset,
                             @RequestParam(defaultValue = "20") int itemPerPage)
    {

    }
}
