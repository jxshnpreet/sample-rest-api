package com.company.samplerestapi.repository;

import com.company.samplerestapi.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,String> {
}
