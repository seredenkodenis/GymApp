package com.project.gym.Repos;

import com.project.gym.Model.User;
import com.project.gym.Model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
    List<Weight> findWeightsByUser(User user);
}
