package com.sports.plan.repositories;

import com.sports.plan.model.Measurement;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeasurementRepository extends MongoRepository<Measurement, Long>{

}
