package com.sports.plan.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sports.plan.model.Exercise;

public interface ExerciseRepository extends MongoRepository<Exercise, Long> {
    
}
