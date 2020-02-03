package controller;

import dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import javax.xml.ws.Response;

@RestController
//@RequestMapping("user")
public class PersonController {
    private UserService userService;

    @Autowired
    public PersonController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Person> get(@PathVariable int id) {
        return new ResponseEntity<Person>(userService.get(id), HttpStatus.OK);
    }

}