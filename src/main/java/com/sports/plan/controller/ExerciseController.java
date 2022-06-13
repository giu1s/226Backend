package com.sports.plan.controller;

import java.util.List;

import com.sports.plan.model.Exercise;
import com.sports.plan.repositories.ExerciseRepository;

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

import com.sports.plan.generator.SequenceGeneratorService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ExerciseController {
    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    SequenceGeneratorService sequenceGenerator;

    /**
     * @return all Exercise
     */
    @GetMapping("/allExercises")
    public List<Exercise> getExercise(){
        return exerciseRepository.findAll();
    }

    /**
     * create Exercise
     * @param newExercise created Exercise
     * @return 
     */
    @PostMapping("/Exercise")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise newExercise){
        newExercise.setId();
        Exercise savedExercise = exerciseRepository.insert(newExercise);
        if ( savedExercise == null ){
            throw new RuntimeException("Coulnd't create Exercise");
        }
        return new ResponseEntity<>(savedExercise, HttpStatus.OK);
    }

    /**
     * update Exercise
     * @param newExercise Exercise with new values
     * @return  
     */
    @PutMapping("/Exercise")
    public ResponseEntity<Exercise> updateExercise(@RequestBody Exercise newExercise){
       Exercise updatedExercise = exerciseRepository.save(newExercise);
       if ( updatedExercise == null ){
        throw new RuntimeException("Coulnd't create Exercise");
        }
        return new ResponseEntity<>(updatedExercise, HttpStatus.OK);
    }

    /**
     * delete Exercise
     * @param id
     * @return
     */
    @DeleteMapping("/Exercise/{id}")
    public ResponseEntity<Exercise> deleteExercise(@PathVariable(value = "id") long id){
       exerciseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
