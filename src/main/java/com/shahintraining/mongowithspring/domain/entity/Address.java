package com.shahintraining.mongowithspring.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Address {
    private String country;
    private String postCode;
    private String state;
}
