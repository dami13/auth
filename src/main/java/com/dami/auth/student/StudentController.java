package com.dami.auth.student;

import com.dami.auth.student.model.Student;
import com.sun.istack.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(0, "James Bond"),
            new Student(1, "Maria Jones"),
            new Student(2, "Anna Smith")
    );

    @GetMapping(path = "/{id}")
    public Student getStudent(@NotNull @PathVariable Integer id) {
        return STUDENTS.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);
    };
}
