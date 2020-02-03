package mn.controller;

import mn.dto.Person;
import mn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class PersonController {
    private UserService userService;

    @Autowired
    public PersonController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<Person>> index() {
        return new ResponseEntity<List<Person>>(userService.getAll(), HttpStatus.OK);
    }

}