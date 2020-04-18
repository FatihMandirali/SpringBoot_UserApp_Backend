package com.example.demo.API;

import com.example.demo.model.ErrorHandlingModel.StudentErrorResponse;
import com.example.demo.model.ErrorHandlingModel.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/error")
public class ErrorHandlingController {

    @GetMapping("/user/{studentId}")
    public String getStudent(@PathVariable int studentId){

        if(studentId>5 || studentId<0){
            throw new StudentNotFoundException("student id not found - "+ studentId);
        }

        return "başarılı";
    }


}
