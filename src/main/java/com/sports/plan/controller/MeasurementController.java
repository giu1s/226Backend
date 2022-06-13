package com.sports.plan.controller;

import java.util.List;

import com.sports.plan.generator.SequenceGeneratorService;
import com.sports.plan.model.Measurement;
import com.sports.plan.repositories.MeasurementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class MeasurementController {
    

    @Autowired
    MeasurementRepository measurementRepository;

    @Autowired
    SequenceGeneratorService sequenceGenerator;

    /**
     * @return all Measurement
     */
    @GetMapping("/allMeasurement")
    public List<Measurement> getMeasurement(){
        return measurementRepository.findAll();
    }

     /**
     * create Measurement
     * @param newMeasurement created measurement
     * @return 
     */
    @PostMapping("/measurement")
    public ResponseEntity<Measurement> createUser(@RequestBody Measurement newMeasurement){
        newMeasurement.setId(sequenceGenerator.generateSequence(Measurement.SEQUENCE_NAME));
        Measurement savedUser = measurementRepository.insert(newMeasurement);
        if ( savedUser == null ){
            throw new RuntimeException("Coulnd't create user");
        }
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    /**
     * update measurement
     * @param new measurement with new values
     * @return  
     */
    @PutMapping("/measurement")
    public ResponseEntity<Measurement> updateUser(@RequestBody Measurement newMeasurement){
        Measurement updatedMeasurement = measurementRepository.save(newMeasurement);
       if ( updatedMeasurement == null ){
        throw new RuntimeException("Coulnd't create measurement");
        }
        return new ResponseEntity<>(updatedMeasurement, HttpStatus.OK);
    }
    /**
     * delete measurement
     * @param id
     * @return
     */
    @DeleteMapping("/measurement/{id}")
    public ResponseEntity<Measurement> deleteUser(@PathVariable(value = "id") long id){
        measurementRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
