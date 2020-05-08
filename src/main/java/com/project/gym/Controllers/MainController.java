package com.project.gym.Controllers;

import com.project.gym.Model.User;
import com.project.gym.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String registrationGet(){
        return "reg";
    }

    @PostMapping("/register")
    public String registrationPost(@RequestParam String name, @RequestParam String email,@RequestParam String phone,@RequestParam String password){

        // TODO check if information is present and it is correct, on front-end base
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
        userService.createUser(user);
        return "index";
    }


}
