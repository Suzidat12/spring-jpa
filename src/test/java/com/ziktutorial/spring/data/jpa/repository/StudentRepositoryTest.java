package com.ziktutorial.spring.data.jpa.repository;

import com.ziktutorial.spring.data.jpa.entity.Guardian;
import com.ziktutorial.spring.data.jpa.entity.Student;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest


class StudentRepositoryTest {
@Autowired
    StudentRepository studentRepository;
@Test
public  void saveStudent(){
    Student student = Student.builder()
            .emailId("oladipupo@gmail.com")
            .firstName("Oladipupo")
            .lastName("Bamidele")
           // .guardianEmail("olos@gmail.com")
           // .guardianName("Adebayo Basit")
           // .guardianMobile("07033266343")
            .build();
    studentRepository.save(student);
}
@Test
public  void saveStudentWithGuardian(){
    Guardian guardian = Guardian.builder()
            .email("oladipupo@gmail.com")
            .name("Oladipupo")
            .mobile("07033215343")
            .build();
    Student student = Student.builder()
                    .firstName("Bolaji")
                    .emailId("adeoye@gmail.com")
                    .lastName("Boluwatife")
                    .guardian(guardian)
                    .build();
    studentRepository.save(student);
}
@Test
    public void studentList(){
    List<Student> studentList= studentRepository.findAll();
    System.out.println("Student list"+ studentList);
}
@Test
    public void findByFirstName(){
    List<Student> student = studentRepository.findByFirstName("Bolaji");
    System.out.println("Print First name" + student);
}

    @Test
    public void findByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("At");
        System.out.println("Print First name" + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("oladipupo");
        System.out.println("Guardian name is" + students);
    }

    @Test
    public void printEmailAddress(){
        Student students = studentRepository.getStudentByEmailAddress("odofin@gmail.com");
        System.out.println("Print" + students);
    }

    @Test
    public void printFirstNameByEmailAddress(){
      String firstName = studentRepository.getStudentFirstNameByEmailAddress("olasunkanmizik@gmail.com");
        System.out.println("Print" + firstName);
    }

    @Test
    public  void printgetStudentByEmailAddressNative(){
        Student students = studentRepository.getStudentByEmailAddressNative("olasunkanmizik@gmail.com");
        System.out.println("Print " + students);
    }
    @Test
    public void updateStudentNameByEmailId(){
    studentRepository.updateStudentNameByEmailId("Olami", "olasunkanmizik@gmail.com");
    }

}