package com.assignment3.repository;

import com.assignment3.domain.ScoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreInfo,Integer> {

//    List<ScoreInfo> findByInstructorId(int instructorId);

}
