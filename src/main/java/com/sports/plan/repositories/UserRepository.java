package com.sports.plan.repositories;


import java.util.UUID;

import com.sports.plan.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, UUID> {

}
