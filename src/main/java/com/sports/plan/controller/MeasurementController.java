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
    @GetMapping("/allmeasurement")
    public List<Measurement> getAllMeasurements(){
        return measurementRepository.findAll();
    }

    /**
     * @return  Measurement by id
     */
    @GetMapping("/measurement/{id}")
    public ResponseEntity<Measurement> getMeasurement(@PathVariable(value = "id") long id){
        return new ResponseEntity<Measurement>(measurementRepository.findById(id).get(), HttpStatus.OK);
    }

     /**
     * create Measurement
     * @param newMeasurement created measurement
     * @return 
     */
    @PostMapping("/measurement")
    public ResponseEntity<Measurement> createMeasurement(@RequestBody Measurement newMeasurement){
        newMeasurement.setId();
        Measurement savedMeasurement = measurementRepository.insert(newMeasurement);
        if ( savedMeasurement == null ){
            throw new RuntimeException("Coulnd't create user");
        }
        return new ResponseEntity<>(savedMeasurement, HttpStatus.OK);
    }

    /**
     * update measurement
     * @param new measurement with new values
     * @return  
     */
    @PutMapping("/measurement")
    public ResponseEntity<Measurement> updateMeasurement(@RequestBody Measurement newMeasurement){
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
    public ResponseEntity<Measurement> deleteMeasurement(@PathVariable(value = "id") long id){
        measurementRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
