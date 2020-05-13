package com.project.gym.Controllers;

import com.project.gym.Model.Article;
import com.project.gym.Model.User;
import com.project.gym.Repos.ArticleRepository;
import com.project.gym.Repos.UserRepository;
import com.project.gym.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @GetMapping("/main")
    public String mainGet(){
        return "admin";
    }


    @GetMapping("/addAboniment")
    public String addAboGet(){
        return "addAboniment";
    }

    @PostMapping("/addAboniment")
    public String addAbonimentPost(@RequestParam Long id, @RequestParam String type){
        User user = userService.findOneId(id);
        user.setAboniment(type);
        userRepository.save(user);
        return "news";
    }


    @GetMapping("/addUser")
    public String addUserGet(){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUserPost(@RequestParam String surname, @RequestParam String name,@RequestParam String aboniment, @RequestParam String phone, @RequestParam String email, @RequestParam String address, @RequestParam String password, @RequestParam String birthday, @RequestParam Long id){
        User user = new User();
        user.setName(name); user.setEmail(email); user.setId(id); user.setAboniment(aboniment); user.setSurname(surname); user.setPassword(password); user.setPhone(phone); user.setAddress(address);
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
            user.setBirthday(date);
        } catch (ParseException e) {
            return "errorBadBirthday";
        }
        userService.createUser(user);
        return "redirect:/admin/searchUser";
    }

    @GetMapping("/deleteAboniment")
    public String deleteAbonimentGet(){
        return "deleteAboniment";
    }

    @PostMapping("/deleteAboniment/delete")
    public String deleteAbonimentPost(@RequestParam String surname, @RequestParam String phone, @RequestParam Long id){
        User user = null;
        if(id != null)
            user = userService.findOneId(id);
        if(phone != null && user==null)
            user = userService.findOnePhone(phone);
        if(surname!=null && user==null)
            user = userService.findOneSurname(surname);
        user.setAboniment(null);
        userRepository.save(user);
        return "redirect:/admin/main";
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

    @PostMapping("/refresh/edit")
    public String refreshPost(@RequestParam Long id, @RequestParam String surname, @RequestParam String name, @RequestParam String phone, @RequestParam String aboniment, @RequestParam Long newNumber){
        User user;
        user = userService.findOneId(id);
        if(user == null)
            return "errorEdit";
        if(name!= null)
            user.setName(name);
        if(surname!= null)
            user.setSurname(surname);
        if(phone!= null)
            user.setPhone(phone);
        if(aboniment != null)
            user.setAboniment(aboniment);
        if(newNumber != null)
            user.setId(newNumber);
        userRepository.save(user);
        return "redirect:/admin/main";
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
