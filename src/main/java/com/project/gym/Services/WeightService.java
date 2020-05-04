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
        List<Weight> bd = user.getWeights();
        if(bd.size() == 0){
            List<Weight> weights = new ArrayList<>();
            weight.setUser(user);
            weightRepository.save(weight);
            weights.add(weight);
            user.setWeights(weights);
            userRepository.save(user);
        }else{
            List<Weight> weights = user.getWeights();
            weight.setUser(user);
            weightRepository.save(weight);
            weights.add(weight);
            user.setWeights(weights);
            userRepository.save(user);
        }
    }

    public List<Weight> userWeights(User user){
        return weightRepository.findWeightsByUser(user);
    }
}
