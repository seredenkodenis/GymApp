package com.project.gym;

import com.project.gym.Model.Task;
import com.project.gym.Model.User;
import com.project.gym.Repos.UserRepository;
import com.project.gym.Services.TaskService;
import com.project.gym.Services.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
class GymApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void initDb() {
        {
            User newUser = new User("user1@mail.com", "user1", "123456");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("user2@mail.com", "User2", "123456");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("admin@mail.com", "admin1", "123456");
            userService.createAdmin(newUser);
        }

        Task userTask = new Task("03/01/2018", "00:11", "11:00", "1");

        Task userTask2 = new Task("11/11/2011", "04:11", "17:00", "second task");
        Task userTask3 = new Task("00/00/2000", "00:00", "00:00", "000000000000000000");

        User user1 = userRepository.findUserByEmail("user1@mail.com");

        taskService.addTask(userTask3, user1);


        User user3 = userRepository.findUserByEmail("admin@mail.com");
        taskService.addTask(userTask, user3);

        taskService.addTask(userTask2,user1);
    }

    @Test
    public void testUser() {
        User user = userService.findOne("user1@mail.com");
        assertNotNull(user);
        User admin = userService.findOne("admin@mail.com");
        assertNotNull(admin);
    }

    @Test
    public void testTask() {
        User user = userRepository.findUserByEmail("user1@mail.com");
        List<Task> task = taskService.findUserTask(user);
        System.out.println("user1 data ------------------------");
        System.out.println(task.size());


    }




}
