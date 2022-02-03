package com.shahintraining.mongowithspring.domain.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Address {
    private String country;
    private String postCode;
    private String state;
}
