package com.shahintraining.mongowithspring;

import com.shahintraining.mongowithspring.domain.entity.Address;
import com.shahintraining.mongowithspring.domain.entity.Student;
import com.shahintraining.mongowithspring.domain.enums.Gender;
import com.shahintraining.mongowithspring.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoWithSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Student shahin = Student.builder().firstName("shahin").lastName("khalajestani").email("shahin@GG.com")
                    .address(Address.builder().country("iran").postCode("sdflkj@##@")
                            .state("Al").build()).gender(Gender.MALE)
                    .favouriteSubjects(List.of("computer Science", "Mathematics"))
                    .totalSpentInBooks(BigDecimal.TEN)
                    .created(LocalDateTime.now()).build();
            repository.save(shahin);
        };
    }

}
