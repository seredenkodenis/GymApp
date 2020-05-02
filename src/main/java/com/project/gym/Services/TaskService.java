package com.project.gym.Services;

import com.project.gym.Model.Task;
import com.project.gym.Model.User;
import com.project.gym.Repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user){

        return taskRepository.findByUser(user);
    }

}
