package one.iamjae.backend.controller;

import one.iamjae.backend.model.User;
import one.iamjae.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        service.createUser(user);
    }
}