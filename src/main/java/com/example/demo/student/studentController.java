package com.example.demo.student;

import com.example.demo.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class studentController {
    private final studentService stService;

    @Autowired
    public studentController(studentService stService) {
        this.stService = stService;
    }

    @GetMapping
    public List<student> getStudents(){
        return stService.getStudents();
    }

    @PostMapping("/register")
    public void registerNewStudent(@RequestBody student s){
        stService.addNewStudent(s);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        stService.deleteStudent(studentId);
    }
}


