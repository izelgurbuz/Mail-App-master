package com.beam.sample.mail.repository;

import com.beam.sample.mail.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByNameAndPassword(String name , String password);

    User findByName(String name);
}
