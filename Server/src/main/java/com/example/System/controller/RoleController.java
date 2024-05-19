package com.example.System.controller;

import com.example.System.entity.Role;
import com.example.System.exception.UserNotFoundException;
import com.example.System.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/roles/table")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody Role role) {
        try {
            return ResponseEntity.ok(roleService.saveRole(role));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateRole(@RequestBody Role role) {
        try {
            return ResponseEntity.ok().body(roleService.updateRole(role));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity<?> getRoles() {
        try {
            return ResponseEntity.ok().body(roleService.findAllRole());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = { "id" })
    public ResponseEntity<?> getOneRole(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(roleService.getOneRole(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(roleService.deleteRole(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
