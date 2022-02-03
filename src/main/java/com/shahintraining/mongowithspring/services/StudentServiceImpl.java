package com.shahintraining.mongowithspring.services;

import com.shahintraining.mongowithspring.domain.dto.StudentDto;
import com.shahintraining.mongowithspring.domain.entity.Student;
import com.shahintraining.mongowithspring.mapper.StudentToStudentDtoMapper;
import com.shahintraining.mongowithspring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentToStudentDtoMapper mapper;

    @Override
    public StudentDto findStudentByEmail(String email) {
        Student student = repository.findStudentByEmail(email).orElseThrow(() ->
                {
                    throw new RuntimeException("no such student");
                }
        );
        return mapper.studentToStudentDto(student);
    }
}
