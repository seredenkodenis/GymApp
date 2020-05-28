package com.project.gym.Services;

import com.project.gym.Model.Plan;
import com.project.gym.Model.Role;
import com.project.gym.Model.User;
import com.project.gym.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanService planService;

    public void createUser(User user) {
        BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        Plan plan = new Plan("Нету записи", "Нету записи", "Нету записи","Нету записи","Нету записи","Нету записи","Нету записи");
        userRepository.save(user);
        planService.addPlan(user,plan);
    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public User findOne(String email) {

        return userRepository.findByEmail(email);
    }

    public User findOneId(Long id){
        return userRepository.findUserById(id);
    }

    public User findOnePhone(String phone){return userRepository.findUserByPhone(phone);}

    public User findOneSurname(String surname){ return userRepository.findUserBySurname(surname);}
}
