package com.project.gym.Services;

import com.project.gym.Model.User;
import com.project.gym.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public void birtdayNotification(Long id, String text ,String type){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.denis-seredenko.com");
        mailSender.setPort(587);
        mailSender.setUsername("admin@denis-seredenko.com");
        mailSender.setPassword("seredenko302003");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        User user = userService.findOneId(id);
        if(type.equals("def")){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("admin@denis-seredenko.com");
            System.out.println(user.getEmail());
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Cообщение от администраторов");
            mailMessage.setText("Привет, "+ user.getName() + "!\n\n" +text +"\n\n С уважением,\n gym-online.");
            mailSender.send(mailMessage);
        }
        if(type.equals("birth")){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("admin@denis-seredenko.com");
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("С днём рождения!");
            mailMessage.setText("Привет, "+ user.getName() + "!\n\n Поздравляем тебя с твоим днём, желаем тебе всего самого лучшего! И в честь твоего ДР дарим тебе 50% скидку на всё! \n\n С уважением,\n gym-online.");
            mailSender.send(mailMessage);
        }
        if(type.equals("connect")){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("admin@denis-seredenko.com");
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Связаться онлайн!");
            mailMessage.setText("Привет, "+ user.getName() + "!\n\n Пожалуйста, зайди на наш сайт и посмотри последнее уведомление, возможно, там что-то интересное:) \n\n С уважением,\n gym-online.");
            mailSender.send(mailMessage);
        }
        if(type.equals("train1")){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("admin@denis-seredenko.com");
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Уникальное предложение от клуба!");
            mailMessage.setText("Привет, "+ user.getName() + "!\n\n Предлагаем тебе уникальную возможность! Проведи 4 тренировки с тренером и получи 1 дополнительно(при условии оплаты сразу) \n\n С уважением,\n gym-online.");
            mailSender.send(mailMessage);
        }
        if(type.equals("train2")){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("admin@denis-seredenko.com");
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Уникальное предложение от клуба!");
            mailMessage.setText("Привет, "+ user.getName() + "!\n\n Предлагаем тебе уникальную возможность! Проведи 20 тренировок с тренером и получи абонимент на месяц бесплатно(при условии оплаты сразу) \n\n С уважением,\n gym-online.");
            mailSender.send(mailMessage);
        }

    }
    public void connectAdmin(String text, User user){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.denis-seredenko.com");
        mailSender.setPort(587);
        mailSender.setUsername("admin@denis-seredenko.com");
        mailSender.setPassword("seredenko302003");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("admin@denis-seredenko.com");
        mailMessage.setTo("denis-seredenko@ukr.net");
        mailMessage.setSubject("Новое сообщение с тренажерного зала");
        mailMessage.setText("Привет вам пришло новое сообщение от пользователя с id: " + user.getId() +"\n\n"+ text +"\n\n С уважением,\n gym-online.");
        mailSender.send(mailMessage);
    }
}
