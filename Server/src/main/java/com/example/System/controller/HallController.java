package com.example.System.controller;

import com.example.System.entity.Hall;
import com.example.System.exception.UserNotFoundException;
import com.example.System.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/halls/table")
public class HallController {
    @Autowired
    private HallService hallService;

    @PostMapping
    public ResponseEntity<?> addHall(@RequestBody Hall hall) {
        try {
            return ResponseEntity.ok(hallService.saveHall(hall));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateHall(@RequestBody Hall hall) {
        try {
            return ResponseEntity.ok().body(hallService.updateHall(hall));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity<?> getHalls() {
        try {
            return ResponseEntity.ok().body(hallService.findAllHall());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = { "id" })
    public ResponseEntity<?> getOneHall(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(hallService.getOneHall(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHall(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(hallService.deleteHall(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
