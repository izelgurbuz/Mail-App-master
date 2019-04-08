package com.beam.sample.mail.repository;

import com.beam.sample.mail.model.Mail;
import com.beam.sample.mail.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

import java.util.List;


public interface MailRepository extends MongoRepository<Mail, String> {
    List<Mail> findByReceiver(User user, Sort sort);
}
