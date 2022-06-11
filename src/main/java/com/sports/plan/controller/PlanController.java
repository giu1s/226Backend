package com.sports.plan.controller;

import java.util.List;

import com.sports.plan.generator.SequenceGeneratorService;
import com.sports.plan.model.Plan;
import com.sports.plan.repositories.PlanRepository;

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
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class PlanController {
    @Autowired
    PlanRepository PlanRepository;

    @Autowired
    SequenceGeneratorService sequenceGenerator;

    /**
     * @return all Plan
     */
    @GetMapping("/api/allPlans")
    public List<Plan> getPlan(){
        return PlanRepository.findAll();
    }

    /**
     * create Plan
     * @param newPlan created Plan
     * @return 
     */
    @PostMapping("/Plan")
    public ResponseEntity<Plan> createPlan(@RequestBody Plan newPlan){
        newPlan.setId(sequenceGenerator.generateSequence(Plan.SEQUENCE_NAME));
        Plan savedPlan = PlanRepository.insert(newPlan);
        if ( savedPlan == null ){
            throw new RuntimeException("Coulnd't create Plan");
        }
        return new ResponseEntity<>(savedPlan, HttpStatus.OK);
    }

    /**
     * update Plan
     * @param newPlan Plan with new values
     * @return  
     */
    @PutMapping("/Plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody Plan newPlan){
       Plan updatedPlan = PlanRepository.save(newPlan);
       if ( updatedPlan == null ){
        throw new RuntimeException("Coulnd't create Plan");
        }
        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }

    /**
     * delete Plan
     * @param id
     * @return
     */
    @DeleteMapping("/Plan/{id}")
    public ResponseEntity<Plan> deletePlan(@PathVariable(value = "id") long id){
       PlanRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
