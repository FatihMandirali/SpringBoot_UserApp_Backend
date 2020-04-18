package com.example.demo.Repository;

import com.example.demo.Entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Integer> {


}
