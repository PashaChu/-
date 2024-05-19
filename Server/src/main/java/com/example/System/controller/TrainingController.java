package com.example.System.controller;

import com.example.System.entity.Training;
import com.example.System.exception.UserNotFoundException;
import com.example.System.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/training/table")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @PostMapping
    public ResponseEntity<?> addTraining(@RequestBody Training training) {
        try {
            return ResponseEntity.ok(trainingService.saveTraining(training));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateTraining(@RequestBody Training training) {
        try {
            return ResponseEntity.ok().body(trainingService.updateTraining(training));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity<?> getTrainings() {
        try {
            return ResponseEntity.ok().body(trainingService.findAllTraining());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = { "id" })
    public ResponseEntity<?> getOneTraining(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(trainingService.getOneTraining(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTraining(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(trainingService.deleteTraining(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
