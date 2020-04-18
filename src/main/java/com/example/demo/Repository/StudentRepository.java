package com.example.demo.Repository;

import com.example.demo.Entities.Student;
import com.example.demo.Entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
