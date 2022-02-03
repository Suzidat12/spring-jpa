package com.ziktutorial.spring.data.jpa.repository;

import com.ziktutorial.spring.data.jpa.entity.Course;
import com.ziktutorial.spring.data.jpa.entity.Student;
import com.ziktutorial.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("Print " + courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Adewale")
                .lastName("Bolaji")
                .build();
        Course course = Course.builder()
                .title("Python")
                .teacher(teacher)
                .credit("7")
                .build();
        courseRepository.save(course);
    }
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);

        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);
        List<Course> courseList = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElement = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("Print all " + totalElement);
        System.out.println("Print all " + courseList);
    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title").descending()
                .and(Sort.by("credit")));
        List<Course> courseList = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0,10);
        List<Course> courseList = courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();
        System.out.println("courseList = " + courseList);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Ahmad")
                .lastName("Dolapo")

                .build();
        Student student = Student.builder()
                .firstName("Boluwatife")
                .lastName("Bolarinwa")
                .emailId("ahmade@gmail.com")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit("12")

                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
        System.out.println("course = " + course);
    }
}