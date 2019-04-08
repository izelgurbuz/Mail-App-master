package com.beam.sample.mail.service;

import com.beam.sample.mail.model.Mail;
import com.beam.sample.mail.model.User;
import com.beam.sample.mail.repository.MailRepository;
import com.beam.sample.mail.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailRepository mailRepository;

    @Autowired
    MailService mailService;

    @Test
    public void testList() {

        userRepository.deleteAll();

        User user = new User()
                .setName("izel")
                .setPassword(UUID.randomUUID().toString());
        user.setId("1");
        //List<Mail> mList = mailRepository.findByReceiver(user);
        //user.setMailList(mList);
        //userService.add(user);
        User user2 = new User()
                .setName("mustafa")
                .setPassword("abc");
        user2.setId("2");
       // mList = mailRepository.findByReceiver(user2);
       // user2.setMailList(mList);
        userService.add(user2);

       // for (int i = 0; i < 5; i++)
          //  userService.createNewMail(user2, user);
        //userRepository.save(user2);
      //  userRepository.save(user);
        //for (int i = 0; i < 7; i++)
          //  userService.createNewMail(user, user2);
        //userRepository.save(user2);
        //userRepository.save(user);
        //List<Mail> temp= userService.getMailList(user2);
        //System.out.println(user2.getMailList().size());

        //assertEquals(5,temp.size());


    }

}
