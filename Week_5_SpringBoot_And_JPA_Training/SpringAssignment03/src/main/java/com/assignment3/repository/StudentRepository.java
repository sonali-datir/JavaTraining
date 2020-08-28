package com.assignment3.repository;

import com.assignment3.domain.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Integer>  {

   // custom query to search student by first name.
   List<StudentInfo> findByFirstName(String firstName);
}
