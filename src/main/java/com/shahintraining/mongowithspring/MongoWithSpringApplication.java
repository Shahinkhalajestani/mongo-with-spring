package com.shahintraining.mongowithspring;

import com.shahintraining.mongowithspring.domain.entity.Address;
import com.shahintraining.mongowithspring.domain.entity.Student;
import com.shahintraining.mongowithspring.domain.enums.Gender;
import com.shahintraining.mongowithspring.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MongoWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoWithSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            String email = "shahin@GG.com";
            Student shahin = Student.builder().firstName("shahin").lastName("khalajestani").email(email)
                    .address(Address.builder().country("iran").postCode("sdflkj@##@")
                            .state("Al").build()).gender(Gender.MALE)
                    .favouriteSubjects(List.of("computer Science", "Mathematics"))
                    .totalSpentInBooks(BigDecimal.TEN)
                    .created(LocalDateTime.now()).build();
//            usingMongoTemlateAndQuery(repository, mongoTemplate, email, shahin);
            Optional<Student> student = repository.findStudentByEmail(email);
            student.ifPresentOrElse(s -> {
                System.out.println("student already exists");
            }, () -> {
                System.out.println("inserting student " + shahin);
                repository.save(shahin);
            });
        };
    }

    private void usingMongoTemlateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student shahin) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        List<Student> students = mongoTemplate.find(query, Student.class);
        if (students.size() > 1) {
            throw new IllegalStateException("found many students with email" + email);
        }
        if (students.isEmpty()) {
            System.out.println("inserting student" + shahin);
            repository.save(shahin);
        }
    }

}
