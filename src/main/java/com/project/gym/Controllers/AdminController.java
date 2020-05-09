package com.project.gym.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/main")
    public String mainGet(){
        return "admin";
    }

    @GetMapping("/addAbonement")
    public String addAboGet(){
        return "addAbonement";
    }

    @GetMapping("/addUser")
    public String addUserGet(){
        return "addUser";
    }

    @GetMapping("/deleteAboniment")
    public String deleteAbonimentGet(){
        return "deleteAboniment";
    }

    @GetMapping("/deleteNews")
    public String deleteNewsGet(){
        return "deleteNews";
    }
    @GetMapping("/deleteUser")
    public String deleteUserGet(){
        return "deleteUser";
    }
    @GetMapping("/findNews")
    public String findNewsGet(){
        return "findNews";
    }
    @GetMapping("/notifyUser")
    public String notifyUserGet(){
        return "notifyUser";
    }
    @GetMapping("/refresh")
    public String refreshGet(){
        return "refresh";
    }
    @GetMapping("/searchUser")
    public String searchUserGet(){
        return "searchUser";
    }
}
