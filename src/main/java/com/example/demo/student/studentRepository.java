package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentRepository extends JpaRepository<student,Long> {
    Optional<student> findStudentByEmail(String email );
}
