package com.project.gym.Controllers;

import com.project.gym.Model.Article;
import com.project.gym.Repos.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ArticleRepository articleRepository;

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
    @GetMapping("/addNews")
    public String addNewsGet(){
        return "addNews";
    }

    @PostMapping("/addNews")
    public String addNewsPost(@RequestParam String title, @RequestParam String text, @RequestParam String shortText){
        Article article = new Article(title, text, shortText);
        articleRepository.save(article);
        return "news";
    }
}
