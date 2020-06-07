package com.project.gym.Controllers;

import com.project.gym.Model.Article;
import com.project.gym.Model.User;
import com.project.gym.Repos.ArticleRepository;
import com.project.gym.Repos.UserRepository;
import com.project.gym.Services.NotificationService;
import com.project.gym.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

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
        Calendar current = user.getDateAboniment();
        if(current == null){
            current = Calendar.getInstance();
        }
        if(type.equals("none")){
            return "redirect:/admin/main";
        }
        if(type.equals("month")){
            current.add(Calendar.MONTH , 1);
            user.setDateAboniment(current);
        }
        if(type.equals("monthAndTrainer")){
            current.add(Calendar.MONTH , 1);
            user.setDateAboniment(current);
        }
        if(type.equals("year")){
            current.add(Calendar.YEAR , 1);
            user.setDateAboniment(current);
        }
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
        if(aboniment.equals("month")){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH,1);
            user.setDateAboniment(calendar);
        }
        if(aboniment.equals("monthAndTrainer")){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH,1);
            user.setDateAboniment(calendar);
        }
        if(aboniment.equals("year")){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 1);
            user.setDateAboniment(calendar);
        }
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
    public String deleteAbonimentGet(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
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
        user.setDateAboniment(null);
        userRepository.save(user);
        return "redirect:/admin/main";
    }

    @GetMapping("/deleteNews")
    public String deleteNewsGet(Model model){
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles",articles);
        return "deleteNews";
    }
    @PostMapping("/deleteNews")
    public String deleteNewsPost(@RequestParam Long id){
        articleRepository.deleteById(id);
        return "redirect:/admin/main";
    }


    @GetMapping("/deleteUser")
    public String deleteUserGet(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "deleteUser";
    }

    @PostMapping("/deleteUser")
    public String deleteUserPos(@RequestParam String surname, @RequestParam String email, @RequestParam String phone, @RequestParam Long id){
        User user = null;
        if(id != null) {
            userRepository.deleteUserById(id);
        }
        if(email != null ){
            userRepository.deleteUserByEmail(email);
        }
        if(phone != null) {
            userRepository.deleteUserByPhone(phone);
        }
        return "redirect:/admin/main";
    }

    @GetMapping("/findNews")
    public String findNewsGet(Model model){
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "findNews";
    }

    @PostMapping("/findNews")
    public String findNewsPost(@RequestParam Long id, Model model){
        Article article = articleRepository.findArticleById(id);
        model.addAttribute("articles",article);
        return "findNews";
    }

    @GetMapping("/notifyUser")
    public String notifyUserGet(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "notifyUser";
    }

    @PostMapping("/notifyUser")
    public String notifyUserPost(@RequestParam Long id, @RequestParam String text, @RequestParam String msgType){
        notificationService.birtdayNotification(id, text, msgType);
        return "redirect:/admin/main";
    }


    @GetMapping("/refresh")
    public String refreshGet(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
            return "refresh";
    }

    @PostMapping("/refresh/edit")
    public String refreshPost(@RequestParam Long id, @RequestParam String surname, @RequestParam String name, @RequestParam String phone, @RequestParam String aboniment, @RequestParam Long newNumber){
        User user = userRepository.findUserById(id);
        if(user == null)
            return "errorEdit";
        if(name.length()!= 0)
            user.setName(name);
        if(surname.length()!= 0)
            user.setSurname(surname);
        if(phone.length()!= 0)
            user.setPhone(phone);
        if(aboniment.length() != 0) {
            if(aboniment.equals("delete")){
               user.setAboniment("deleted");
               user.setDateAboniment(null);
            }
            if(aboniment.equals("month") || aboniment.equals("monthAndTrainer")){
                user.setAboniment(aboniment);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH,1);
                user.setDateAboniment(calendar);
            }
            if(aboniment.equals("year")){
                user.setAboniment(aboniment);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.YEAR,1);
                user.setDateAboniment(calendar);
            }
        }
        if(newNumber != null)
            user.setId(newNumber);
        userRepository.save(user);
        return "redirect:/admin/main";
    }


    @GetMapping("/searchUser")
    public String searchUserGet(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "searchUser";
    }

    @GetMapping("/searchAbo")
    public String searcAbo(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "searchAbo";
    }

    @PostMapping("/searchUser")
    public String searchUserPost(@RequestParam String surname, @RequestParam String email, @RequestParam String phone, @RequestParam Long id, Model model){
        List<User> users = null;
        if(surname.length() !=0){
            users = userRepository.findUsersBySurname(surname);
        }
        if(email.length()!=0){
            users = Collections.singletonList(userRepository.findUserByEmail(email));
        }
        if(phone.length()!=0){
            users = Collections.singletonList(userRepository.findUserByPhone(phone));
        }
        if(id != null ){
            users = Collections.singletonList(userRepository.findUserById(id));
        }
        model.addAttribute("users",users);
        return "searchUser";
    }
    @PostMapping("/searchAbo")
    public String searchAboPost(@RequestParam String surname, @RequestParam String email, @RequestParam String phone, @RequestParam Long id, Model model){
        List<User> users = null;
        if(surname.length() !=0){
            users = userRepository.findUsersBySurname(surname);
        }
        if(email.length()!=0){
            users = Collections.singletonList(userRepository.findUserByEmail(email));
        }
        if(phone.length()!=0){
            users = Collections.singletonList(userRepository.findUserByPhone(phone));
        }
        if(id != null ){
            users = Collections.singletonList(userRepository.findUserById(id));
        }
        model.addAttribute("users",users);
        return "searchAbo";
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
