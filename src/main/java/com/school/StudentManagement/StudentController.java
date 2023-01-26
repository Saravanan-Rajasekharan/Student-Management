package com.school.StudentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // Spring annotation

public class StudentController {

    StudentService studentService;


    //Get the information
    @GetMapping("/getStudent")
    public Student getStudent(@RequestParam("q") int admnNo){
        return studentService.getStudent(admnNo);
    }

    //PathVariable
//   @GetMapping("/getStudent/{admnNo}")
//    public Student getStudent(@PathVariable("admnNo") int admnNo){
//        return db.get(admnNo);
//    }

// Multiple request parameters
//    @GetMapping("/getStudent")
//    public Student getStudent(@RequestBody(admnNo) int admnNo,@RequestBody(name) String name){
//        return db.get(admnNo);
//    }

    //  /getStudent?admnNo=1000&name="Sachin"

    //Adding the information

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
       return studentService.addStudent(student);
    }

    //Delete based on admn number

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("q") int admnNo){
        if(!db.containsKey(admnNo)){
            return "Student info not present!, Please recheck the admission number";
        } else{
            db.remove(admnNo);
        }
        return "Student info deleted!";
    }



    //Put based on admn number and update one parameter

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestParam("id")int id, @RequestParam ("age") int age){
        if(!db.containsKey(id)){
            return "Student not present";
        }
        db.get(id).setAge(age);

        return "Updated Successfully";
    }



}
