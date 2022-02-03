package com.shahintraining.mongowithspring.mapper;

import com.shahintraining.mongowithspring.domain.dto.AddressDto;
import com.shahintraining.mongowithspring.domain.dto.StudentDto;
import com.shahintraining.mongowithspring.domain.entity.Address;
import com.shahintraining.mongowithspring.domain.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentToStudentDtoMapper {
    Student studentDtoToStudent(StudentDto studentDto);
    StudentDto studentToStudentDto(Student student);
    Address addressDtoToAddress(AddressDto addressDto);
    AddressDto addressToAddressDto(Address address);
}
