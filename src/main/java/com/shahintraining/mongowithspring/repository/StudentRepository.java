package com.shahintraining.mongowithspring.repository;

import com.shahintraining.mongowithspring.domain.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {
}
