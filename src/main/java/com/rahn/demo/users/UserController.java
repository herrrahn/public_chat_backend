package com.rahn.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/ola")
    public String ola() {
        return "rrr";
    }

    @PostMapping("/save")
    public User save( @RequestParam("login") String login,
                      @RequestParam("password") String password) {
        return userRepository.save(new User(login, password));
    }

}
