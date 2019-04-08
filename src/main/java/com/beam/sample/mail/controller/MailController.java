package com.beam.sample.mail.controller;

import com.beam.sample.mail.model.Mail;
import com.beam.sample.mail.model.User;
import com.beam.sample.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.beam.sample.mail.model.Constants.SESSION_USER;

@RestController
@RequestMapping("mail")
public class MailController {
    @Autowired
    MailService mailService;

  /*  @GetMapping("list")
    public List<Mail> list() {

        return mailService.list();
    }*/

    @PostMapping("add")
    public Mail add(@RequestBody Mail mail) {

        return mailService.add(mail);
    }

    @PostMapping("remove")
    public void remove(@RequestParam("id") String id) {

        mailService.removeById(id);
    }

    @PostMapping("inbox")
    public List<Mail> getMailList(@RequestBody User user) {

        return mailService.getInbox(user);
    }

    @PostMapping("new-mail")
    public Mail createNewMail(@RequestBody Mail mail, HttpSession session) {

        if (session.getAttribute(SESSION_USER) != null) {
            User sender = (User) session.getAttribute(SESSION_USER);
            return mailService.createNewMail(mail, sender);
        } else
            return null;
    }

    @GetMapping("{id}")
    public Mail getMail(@PathVariable("id") String id) {
        return mailService.get(id);
    }

    @PostMapping("update-read")
    public Mail updateRead(@RequestBody Mail openedM, HttpSession session) {
        if(session.getAttribute(SESSION_USER) != null) {
            return mailService.updateRead(openedM);
        }
        else
            return null;

    }

}
