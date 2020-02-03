package controller;

import dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("user")
public class PersonController {
    private UserService userService;

    @Autowired
    public PersonController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public Person get(@PathVariable(name = "id") int id) {
        return userService.get(id);
    }
}
