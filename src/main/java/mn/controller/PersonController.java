package mn.controller;

import mn.dto.Person;
import mn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class PersonController {
    private UserService userService;

    @Autowired
    public PersonController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> index(@PathVariable int id) {
        return new ResponseEntity<Person>(userService.get(id), HttpStatus.OK);
    }

}