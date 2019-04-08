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
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailRepository mailRepository;

    @Autowired
    MailService mailService;

    public User add(User user) {
        return userRepository.insert(user);

    }
    public  User update(User user){
        return userRepository.save(user);
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void removeById(String id) {
        userRepository.deleteById(id);
    }

    public User authenticateUser(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }

    public User getUser(String id) {
        Optional<User> op = userRepository.findById(id);

        if (op.isPresent())
            return op.get();
        else
            return null;
    }
    public User getUserByName(String name){
        return userRepository.findByName(name);
    }

    public List<Mail> getMailList(User user) {

        return mailRepository.findByReceiver(user, new Sort(Sort.Direction.DESC, "date"));
    }


}
