package com.shahintraining.mongowithspring.controllers;

import com.shahintraining.mongowithspring.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/get-by-email")
    public ResponseEntity<?> getByEmail(@RequestParam(name = "mail") String email) {
        return ResponseEntity.ok(studentService.findStudentByEmail(email));
    }
}
