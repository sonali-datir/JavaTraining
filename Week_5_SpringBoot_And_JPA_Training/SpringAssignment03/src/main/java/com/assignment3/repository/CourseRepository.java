package com.assignment3.repository;

import com.assignment3.domain.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseInfo, Integer> {

    List<CourseInfo> findByCourseName(String courseName);

}
