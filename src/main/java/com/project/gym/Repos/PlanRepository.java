package com.project.gym.Repos;

import com.project.gym.Model.Plan;
import com.project.gym.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    Plan findByUser(User user);
}
