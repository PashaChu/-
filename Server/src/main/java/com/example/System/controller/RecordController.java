package com.example.System.controller;

import com.example.System.entity.RecordCenter;
import com.example.System.exception.UserNotFoundException;
import com.example.System.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/records/table")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @PostMapping
    public ResponseEntity<?> addRecord(@RequestBody RecordCenter record) {
        try {
            return ResponseEntity.ok(recordService.saveRecord(record));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateRecord(@RequestBody RecordCenter record) {
        try {
            return ResponseEntity.ok().body(recordService.updateRecord(record));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity<?> getRecords() {
        try {
            return ResponseEntity.ok().body(recordService.findAllRecord());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = { "id" })
    public ResponseEntity<?> getOneRecord(@RequestParam Long id, @RequestParam String login, @RequestParam String password) {
        try {
            return ResponseEntity.ok().body(recordService.getOneRecord(id, login, password));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecord(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(recordService.deleteRecord(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
