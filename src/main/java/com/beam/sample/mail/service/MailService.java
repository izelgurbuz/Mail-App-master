package com.beam.sample.mail.service;

import com.beam.sample.mail.model.Mail;
import com.beam.sample.mail.model.User;
import com.beam.sample.mail.repository.MailRepository;
import com.beam.sample.mail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MailService {

    @Autowired
    MailRepository mailRepository;
    @Autowired
    UserRepository userRepository;

    public List<Mail> list() {

        return mailRepository.findAll();
    }

    public Mail add(Mail mail) {

        return mailRepository.insert(mail);
    }

    public void removeById(String id) {

        mailRepository.deleteById(id);
    }

    public List<Mail> getInbox(User user) {
        return mailRepository.findByReceiver(user, new Sort(Sort.Direction.DESC, "date"));
    }

    public Mail createNewMail(Mail mail, User sender) {

        mail.setSender(sender);
        mail.setId(UUID.randomUUID().toString());
        mail.setDate(new Date());
        mailRepository.insert(mail);

        //  List<Mail> arr = receiver.getMailList();
        //arr.add(mail);
        // receiver.setMailList(arr);
        //userRepository.save(receiver);



        return mail;
    }

    public Mail get(String id) {

        Optional<Mail> op = mailRepository.findById(id);
        Mail mail = op.get();
        return mail;
    }

    public Mail updateRead(Mail mail) {

         return mailRepository.save(mail);
    }

}
