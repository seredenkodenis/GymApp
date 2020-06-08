package com.project.gym;

import com.project.gym.Model.Plan;
import com.project.gym.Model.Task;
import com.project.gym.Model.User;
import com.project.gym.Model.Weight;
import com.project.gym.Repos.UserRepository;
import com.project.gym.Services.PlanService;
import com.project.gym.Services.TaskService;
import com.project.gym.Services.UserService;
import com.project.gym.Services.WeightService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
class GymApplicationTests {

    /*@Test
    void contextLoads() {
    }
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private PlanService planService;
    @Autowired
    private WeightService weightService;
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
    public void temp(){
        User newUser = new User("user10@mail.com", "user4", "123456");
        newUser.setId((long) 1);
        userService.createUser(newUser);
    }

    @Test
    public void testTask() {
        User user = userRepository.findUserByEmail("user1@mail.com");
        List<Task> task = taskService.findUserTask(user);
        System.out.println("user1 data ------------------------");
        System.out.println(task.size());
    }

    @Test
    public void addTestPlan(){
        Plan plan = new Plan("monday", "tuesday", "wednesday","thursday","friday","saturday","sunday");
        User user = userService.findOne("admin@mail.com");
        planService.addPlan(user,plan);
    }

    @Test
    public void getTestPlan(){
        User user = userService.findOne("admin@mail.com");
        Plan plan = user.getPlan();
        System.out.println(plan.getMon());
    }

    @Test
    public void addWeight(){
        User user = userService.findOne("user1@mail.com");
        Date date = new Date();
        Weight weight = new Weight(date,82.3f,"just a test");
        weightService.addWeight(user,weight);
    }

    @Test
    public void getWeight(){
        User user = userService.findOne("user1@mail.com");
        List<Weight> weights = weightService.userWeights(user);
        if(weights.size() == 0){
            System.out.println("SORRE BRO ONLY 0");
        }else{
            System.out.println(weights.get(0).getWeight());
        }
    }*/

}
