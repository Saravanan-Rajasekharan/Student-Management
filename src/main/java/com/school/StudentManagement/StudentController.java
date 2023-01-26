package com.school.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //Get the information
    @GetMapping("/getStudent")
    public Student getStudent(@RequestParam("q") int admnNo){
        return studentService.getStudent(admnNo);
    }

    //Adding the information
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
       return studentService.addStudent(student);
    }

    //Delete based on admn number
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("q") int admnNo){
        return studentService.deleteStudent(admnNo);
    }

    //Put based on admn number and update one parameter

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestParam("id")int id, @RequestParam ("age") int age){
        return studentService.updateStudent(id,age);
    }


}
