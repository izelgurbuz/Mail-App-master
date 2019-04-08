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

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
    MailService mailService;

    @Autowired
    MailRepository mailRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void remove(){
        mailRepository.deleteAll();
    }

    @Test
    public void testList() {
        User receiverUser = new User()
                .setName("Mehmet")
                .setPassword("ialmehmet");
        receiverUser.setId(UUID.randomUUID().toString());
        User sendUser = new User()
                .setName("Sinem")
                .setPassword("3223snm");
        sendUser.setId(UUID.randomUUID().toString());
        Mail mail = new Mail()
                .setDate(new Date())
                .setRead(true)
                .setContent("BEAM A.Ş genel toplantı")
                .setReceiver(receiverUser)
                .setSender(sendUser);
        mail.setId(UUID.randomUUID().toString());
        mailRepository.insert(mail);
        List<Mail> mailList = mailService.list();

    }

    @Test
    public void testAddMail() {
        mailRepository.deleteAll();
        for (int i = 0; i < 20; i++) {
            Mail mail = new Mail()
                    .setDate(new Date())
                    .setRead(true)
                    .setContent("BEAM A.Ş genel toplantı " + i)
                    .setReceiver(userRepository.findAll().get(i + 20))
                    .setSender(userRepository.findAll().get(i));
            mail.setId(UUID.randomUUID().toString());
            mailService.add(mail);
        }
    }

    @Test
    public void testRemoveMail() {
        User receiverUser3 = new User()
                .setName("Derya Akkuş")
                .setPassword("3542");
        receiverUser3.setId(UUID.randomUUID().toString());
        User sendUser3 = new User()
                .setName("Talat")
                .setPassword("4242");
        sendUser3.setId(UUID.randomUUID().toString());
        Mail mail = new Mail()
                .setDate(new Date())
                .setRead(true)
                .setContent("BEAM A.Ş genel toplantı")
                .setReceiver(receiverUser3)

                .setSender(sendUser3);
        mail.setId(UUID.randomUUID().toString());
        mailRepository.insert(mail);
        List<Mail> mailList = mailService.list();
        mailService.removeById(mail.getId());

    }
}
