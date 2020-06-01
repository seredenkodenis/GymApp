package com.project.gym.Repos;

import com.project.gym.Model.Task;
import com.project.gym.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    Task findTaskById(Long id);
}
