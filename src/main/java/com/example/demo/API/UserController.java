package com.example.demo.API;

import com.example.demo.ConfigValue;
import com.example.demo.Entities.Student;
import com.example.demo.Entities.Users;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Example1;
import com.example.demo.services.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private StudentRepository _studentRepository;
    private final ConfigValue config;
    private final UserService userService;

    @Autowired
    MessageSource messageSource;

    public UserController(ConfigValue config, UserService userService) {
        this.config = config;
        this.userService = userService;
    }

    @PostMapping("/postAddUser")
    public String postAddUser(@RequestBody Users users) {
        if (users.getLastName().isEmpty() || users.getUserName().isEmpty())
            return "Lütfen boş yerleri doldurun";
        _userRepository.save(users);
        return "Kullanıcı Eklendi";
    }


    @ApiOperation(value = "Returns Students",
            notes = "İsteği atarken Param değeri olarak language değerinide yollayınız.", response = Student.class,
            responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Sayfa bulunamadı")})
    @ApiModelProperty(value = "pet status in the store", allowableValues = "available,pending,sold")
    @GetMapping("/getStudents")
    public List<Student> getStudents(@RequestParam("language") String lang) {


        List<Student> studentss = (List<Student>) _studentRepository.findAll();

        return studentss;
    }


    @GetMapping("/getUsers")
    public List<Users> getUsers() {
        List<Users> users = userService.GetUsers();
        return users;
    }


    @GetMapping(value = "/getUser/{id}")
    public Optional<Users> getUser(@PathVariable(required = false) String id) {

        Optional<Users> users = _userRepository.findById(Integer.parseInt(id));
        return users;
    }

    @PostMapping(value = "/updateUser")
    public Users updateUser(@RequestBody Users users) {

        Users user = _userRepository.findById(users.getId()).get();
        user.setLastName(users.getLastName());
        user.setUserName(users.getUserName());
        _userRepository.save(user);
        return users;
    }

}
