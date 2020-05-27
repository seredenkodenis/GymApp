package com.project.gym.Services;

import com.project.gym.Model.User;
import com.project.gym.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StoreFile {
    @Autowired
    private UserRepository userRepository;

    public void storeFile(User user, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            user.setPicture(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        userRepository.save(user);
    }

    public byte[] getPicture(User user){
        byte[] image = user.getPicture();
        return image;
    }

}
