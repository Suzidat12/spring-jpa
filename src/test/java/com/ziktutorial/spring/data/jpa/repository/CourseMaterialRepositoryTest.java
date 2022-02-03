package com.ziktutorial.spring.data.jpa.repository;

import com.ziktutorial.spring.data.jpa.entity.Course;
import com.ziktutorial.spring.data.jpa.entity.CourseMaterial;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CourseMaterialRepositoryTest {
@Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .credit("64")
                .title(".net")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("wwww.dailybuffer.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterialList= courseMaterialRepository.findAll();
        System.out.println("Print Course " + courseMaterialList);
    }
}