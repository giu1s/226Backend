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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class PlanController {
    @Autowired
    PlanRepository planRepository;

    @Autowired
    SequenceGeneratorService sequenceGenerator;

    /**
     * @return all Plan
     */
    @GetMapping("/allPlans")
    public List<Plan> getPlan(){
        return planRepository.findAll();
    }

    /**
     * @return  Plan by id
     */
    @GetMapping("/plan/{id}")
    public ResponseEntity<Plan> getUser(@PathVariable(value = "id") long id){
        return new ResponseEntity<Plan>(planRepository.findById(id).get(), HttpStatus.OK);
    }

    /**
     * create Plan
     * @param newPlan created Plan
     * @return 
     */
    @PostMapping("/plan")
    public ResponseEntity<Plan> createPlan(@RequestBody Plan newPlan){
        newPlan.setId();
        Plan savedPlan = planRepository.insert(newPlan);
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
    @PutMapping("/plan")
    public ResponseEntity<Plan> updatePlan(@RequestBody Plan newPlan){
       Plan updatedPlan = planRepository.save(newPlan);
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
    @DeleteMapping("/plan/{id}")
    public ResponseEntity<Plan> deletePlan(@PathVariable(value = "id") long id){
       planRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
