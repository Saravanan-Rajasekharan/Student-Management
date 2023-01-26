package com.school.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //Get the information
    @GetMapping("/getStudent")
    public ResponseEntity getStudent(@RequestParam("q") int admnNo){
        Student student = studentService.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    //Adding the information
    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody Student student){
      String response = studentService.addStudent(student);
      return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //Delete based on admn number
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int admnNo){
        String response = studentService.deleteStudent(admnNo);
        if(response.equals("Invalid")) {
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    //Put based on admn number and update one parameter

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestParam("id")int id, @RequestParam("age") int age){
        String response = studentService.updateStudent(id,age);
        if(response==null){
            return new ResponseEntity<>("Invalid Request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Updated",HttpStatus.ACCEPTED);
    }


}
