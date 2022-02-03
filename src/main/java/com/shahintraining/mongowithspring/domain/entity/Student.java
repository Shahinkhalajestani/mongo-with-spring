package com.shahintraining.mongowithspring.domain.entity;


import com.shahintraining.mongowithspring.domain.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
@Builder
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    @Indexed(unique = true)
    private String email;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;
}
