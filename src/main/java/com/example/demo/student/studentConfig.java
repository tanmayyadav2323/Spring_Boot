package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(studentRepository repository){
        return args -> {
        student tanmay =     new student(
                    "Tanmay",
                    LocalDate.of(2000, Month.JANUARY,6),

                    "tanmay@gmail.com"
            );
            student alex =     new student(
                    "Alex",
                    LocalDate.of(2004, Month.JANUARY,6),

                    "tanmay@gmail.com"
            );
            repository.saveAll(
                    List.of(tanmay,alex)
            );
        };
    }
}
