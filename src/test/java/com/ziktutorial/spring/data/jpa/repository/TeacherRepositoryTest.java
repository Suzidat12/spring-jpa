package com.ziktutorial.spring.data.jpa.repository;

import com.ziktutorial.spring.data.jpa.entity.Course;
import com.ziktutorial.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
@Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .credit("5")
                .title("DBA")
                .build();
        Course courseJava = Course.builder()
                .credit("4")
                .title("Java")
                .build();
        Course coursePHP = Course.builder()
                .credit("3")
                .title("PHP")
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Odofin")
                .lastName("Timothy")
              //  .courseList(List.of(courseDBA,courseJava,coursePHP))
                .build();
        teacherRepository.save(teacher);
    }
}