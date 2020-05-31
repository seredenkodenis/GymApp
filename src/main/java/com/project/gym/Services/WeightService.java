package com.project.gym.Services;

import com.project.gym.Model.User;
import com.project.gym.Model.Weight;
import com.project.gym.Repos.UserRepository;
import com.project.gym.Repos.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeightService{
    @Autowired
    private WeightRepository weightRepository;

    @Autowired
    private UserRepository userRepository;

    public void addWeight(User user, Weight weight){
        weight.setUser(user);
        weightRepository.save(weight);
    }

    public List<Weight> userWeights(User user){
        return weightRepository.findWeightsByUser(user);
    }
}
