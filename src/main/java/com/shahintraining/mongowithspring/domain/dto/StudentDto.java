package com.shahintraining.mongowithspring.domain.dto;

import com.shahintraining.mongowithspring.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private AddressDto address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;
}
