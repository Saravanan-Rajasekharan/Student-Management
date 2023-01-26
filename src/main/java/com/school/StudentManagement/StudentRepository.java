package com.school.StudentManagement;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> db = new HashMap<>();

    public Student getStudent(int id){
        return db.get(id);
    }
    public String addStudent(Student student){
        int id = student.getAdmnNo();
        db.put(id,student);
        return "Added successfully";
    }

    public String deleteStudent(int admnNo){
        if(!db.containsKey(admnNo)){
            return "Invalid";
        } else{
            db.remove(admnNo);
        }
        return "Student info deleted!";
    }


    public String updateStudent(int id, int age){
        if(!db.containsKey(id)){
            return null;
        }
        db.get(id).setAge(age);
        return "Updated Successfully";
    }


}
