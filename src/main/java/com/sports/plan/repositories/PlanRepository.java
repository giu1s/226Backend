package com.sports.plan.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sports.plan.model.Plan;

public interface PlanRepository extends MongoRepository<Plan, Long> {
    
}
