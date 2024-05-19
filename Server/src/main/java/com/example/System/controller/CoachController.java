package com.example.System.controller;

import com.example.System.entity.Coach;
import com.example.System.exception.UserNotFoundException;
import com.example.System.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/coaches/table")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @PostMapping
    public ResponseEntity<?> addCoach(@RequestBody Coach coach) {
        try {
            return ResponseEntity.ok(coachService.saveCoach(coach));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateCoach(@RequestBody Coach coach) {
        try {
            return ResponseEntity.ok().body(coachService.updateCoach(coach));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity<?> getCoaches() {
        try {
            return ResponseEntity.ok().body(coachService.findAllCoach());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = { "id" })
    public ResponseEntity<?> getOneCoach(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(coachService.getOneCoach(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCoach(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(coachService.deleteCoach(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
