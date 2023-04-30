package com.example.demo.student;

import com.example.demo.student.student;
import com.example.demo.student.studentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class studentService {

    private final studentRepository stRepository;

    @Autowired
    public studentService(studentRepository stRepository) {
        this.stRepository = stRepository;
    }

    public List<student> getStudents(){
        return stRepository.findAll();
    }

    public void addNewStudent(student s) {
        Optional<student> studentOptional = stRepository.findStudentByEmail(s.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        else stRepository.save(s);

        System.out.println(s);
    }

    @Transactional
    public void deleteStudent(Long id) {
      boolean exists =   stRepository.existsById(id);

      if(!exists){
          throw new IllegalStateException("student with id"+ id);
      }
      stRepository.deleteById(id);
    }
}
