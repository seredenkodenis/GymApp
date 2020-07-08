package com.project.gym.Controllers;

import com.project.gym.Model.User;
import com.project.gym.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


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
    public String registrationPost(@RequestParam String name, @RequestParam String email,@RequestParam String phone,@RequestParam String password, Model model){
        User test = userService.findOne(email);
        if (test != null){
            model.addAttribute("exists", true);
            return "reg";
        }
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
        userService.createUser(user);
        return "profileMain";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

}
