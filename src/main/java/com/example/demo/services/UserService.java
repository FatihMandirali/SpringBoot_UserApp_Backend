package com.example.demo.services;

import com.example.demo.Entities.Users;
import com.example.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private  UserRepository userRepository;


    public List<Users> GetUsers(){
        return  (List<Users>) userRepository.findAll();
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
