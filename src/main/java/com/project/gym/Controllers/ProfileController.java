package com.project.gym.Controllers;

import com.project.gym.Model.User;
import com.project.gym.Repos.UserRepository;
import com.project.gym.Services.StoreFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {
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
        model.addAttribute("name",user.getName());
        model.addAttribute("birthday",user.getBirthday());
        model.addAttribute("typeAbo",user.getAboniment());
        model.addAttribute("surname", user.getSurname());
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
    public String planGet(){
        return "trainingPlan";
    }
}
