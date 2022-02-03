package com.ziktutorial.spring.data.jpa.repository;


import com.ziktutorial.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {

    List<Student> findByFirstName (String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL is based on the class you created and not based on database.
   @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);
   //JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String  getStudentFirstNameByEmailAddress(String emailId);
    //Native Query
    @Query(value = "SELECT * from tbl_name s where s.email_address=?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    //Native Query Param
    @Query(value = "SELECT * from tbl_name s where s.email_address=:emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update tbl_name set first_name=?1 where email_address=?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);
}
