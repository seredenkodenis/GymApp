package com.project.gym.Controllers;

import com.project.gym.Model.Plan;
import com.project.gym.Model.Task;
import com.project.gym.Model.User;
import com.project.gym.Model.Weight;
import com.project.gym.Repos.TaskRepository;
import com.project.gym.Repos.UserRepository;
import com.project.gym.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private PlanService planService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private WeightService weightService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("")
    public String profileMain(Principal principal, Model model){
        User user = userRepository.findUserByEmail(principal.getName());
        if(user.getPicture() == null) {
            model.addAttribute("image", true);
            model.addAttribute("image2", false);
        }else{
            model.addAttribute("image", false);
            model.addAttribute("image2", true);
        }
        Calendar user_end_aboniment = user.getDateAboniment();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy ");
//        String formatted = format1.format(user_end_aboniment.getTime());
        model.addAttribute("name",user.getName());
        model.addAttribute("birthday",user.getBirthday());
        model.addAttribute("typeAbo",user.getAboniment());
        model.addAttribute("surname", user.getSurname());
       // model.addAttribute("endAbo",formatted);
        return "profileMain";
    }
    @GetMapping("/getImage")
    public ResponseEntity<ByteArrayResource> image(Principal principal){
        User user = userRepository.findUserByEmail(principal.getName());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+user.getName()+"\"")
                .body(new ByteArrayResource(user.getPicture()));
    }

    @Autowired
    private StoreFile storeFile;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, Principal principal) {
        User currentUser = userRepository.findUserByEmail(principal.getName());
        for (MultipartFile file: files) {
            storeFile.storeFile(currentUser,file);
        }
        return "redirect:/profile";
    }

    @GetMapping("/trainingPlan")
    public String planGet(Principal principal, Model model){
        User user = userRepository.findUserByEmail(principal.getName());
        Plan plan = user.getPlan();
        model.addAttribute("mon",plan.getMon());
        model.addAttribute("tue",plan.getTue());
        model.addAttribute("wen",plan.getWen());
        model.addAttribute("thu",plan.getThu());
        model.addAttribute("fri",plan.getFri());
        model.addAttribute("sat",plan.getSat());
        model.addAttribute("sun",plan.getSun());
        return "trainingPlan";
    }

    @PostMapping("/changePlan/{day}")
    public String planPost(@PathVariable("day")String day,@RequestParam String text,Principal principal){
        User user = userRepository.findUserByEmail(principal.getName());
        Plan plan = user.getPlan();
        if(day.equals("mon")){
            plan.setMon(text);
        }
        if(day.equals("tue")){
            plan.setTue(text);
        }
        if(day.equals("wen")){
            plan.setWen(text);
        }
        if(day.equals("thu")){
            plan.setThu(text);
        }
        if(day.equals("fri")){
            plan.setFri(text);
        }
        if(day.equals("sat")){
            plan.setSat(text);
        }
        if(day.equals("sun")){
            plan.setSun(text);
        }
        planService.addPlan(user,plan);
        userRepository.save(user);
        return "redirect:/profile/trainingPlan";
    }

    @GetMapping("/restDay/{day}")
    public String restDay(@PathVariable("day")String day,Principal principal){
        User user = userRepository.findUserByEmail(principal.getName());
        Plan plan = user.getPlan();
        if(day.equals("mon")){
            plan.setMon("Отдохни");
        }
        if(day.equals("tue")){
            plan.setTue("Отдохни");
        }
        if(day.equals("wen")){
            plan.setWen("Отдохни");
        }
        if(day.equals("thu")){
            plan.setThu("Отдохни");
        }
        if(day.equals("fri")){
            plan.setFri("Отдохни");
        }
        if(day.equals("sat")){
            plan.setSat("Отдохни");
        }
        if(day.equals("sun")){
            plan.setSun("Отдохни");
        }
        planService.addPlan(user,plan);
        userRepository.save(user);
        return "redirect:/profile/trainingPlan";
    }
    @GetMapping("/connectAdministration")
    public String connect(){
        return "connectAdministration";
    }

    @PostMapping("/connectAdministration")
    public String connectPost(Principal principal,@RequestParam String text){
        User user = userRepository.findUserByEmail(principal.getName());
        notificationService.connectAdmin(text,user);
        return "redirect:/profile/";
    }

    @GetMapping("/weightControl")
    public String weightControl(Principal principal, Model model){
        User user = userRepository.findUserByEmail(principal.getName());
        List<Weight> weightList = user.getWeights();
        model.addAttribute("weights", weightList);
        return "weightControl";
    }
    @PostMapping("/weightControl")
    public String weightControlPost(@RequestParam String description, @RequestParam Float weight, Principal principal){
        User user = userRepository.findUserByEmail(principal.getName());
        Date date = new Date();
        Weight weight1 = new Weight(date,weight,description);
        weightService.addWeight(user,weight1);
        userRepository.save(user);
        return "redirect:/profile/weightControl";
    }

    @PostMapping("/addTask")
    public String addTaskPost(@RequestParam String text, Principal principal){
        User user = userRepository.findUserByEmail(principal.getName());
        Date date = new Date();
        Task task = new Task(date.toString(),text);
        taskService.addTask(task,user);
        userRepository.save(user);
        return "redirect:/profile/diary";
    }

    @GetMapping("/diary")
    public String diaryGet(Principal principal, Model model){
        User user = userRepository.findUserByEmail(principal.getName());
        List<Task> tasks = user.gettasks();
        model.addAttribute("tasks",tasks);
        return "diary";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") Long id, Principal principal){
        User user = userRepository.findUserByEmail(principal.getName());
        Task task = taskRepository.findTaskById(id);
        taskRepository.delete(task);
        userRepository.save(user);
        return "redirect:/profile/diary";
    }

    @GetMapping("/paymentSuccess")
    public String keke(){
        return "Your payment was succesfull";
    }

    @GetMapping("/counters")
    public String counters(){
        return "counters";
    }
}
