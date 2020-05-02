package com.project.gym.Services;

import com.project.gym.Model.Plan;
import com.project.gym.Model.User;
import com.project.gym.Repos.PlanRepository;
import com.project.gym.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    @Autowired
    private UserRepository userRepository;

    public void addPlan(User user, Plan plan){
        user.setPlan(plan);
        userRepository.save(user);
    }
}
