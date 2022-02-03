package com.shahintraining.mongowithspring.services;

import com.shahintraining.mongowithspring.domain.dto.StudentDto;
import com.shahintraining.mongowithspring.domain.entity.Student;

public interface StudentService {
    StudentDto findStudentByEmail(String email);
}
