package com.assignment3.controller;

import com.assignment3.domain.ScoreInfo;
import com.assignment3.exception.ResourceNotFoundException;
import com.assignment3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ScoreController {

    @Autowired
    ScoreRepository scoreRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/scores")
    public List<ScoreInfo> getAllScores(){
        return scoreRepository.findAll();
    }

//    @GetMapping("/instructors/{instructorId}/courses")
//    public List < ScoreInfo > getCoursesByInstructor(@PathVariable(value = "postId") int instructorId) {
//        return scoreRepository.findByInstructorId(instructorId);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/create/scores")
    public ScoreInfo createScore(@Valid @RequestBody Map<String, String> body){
        int score = Integer.parseInt(body.get("score"));

        String startDate = body.get("startDateTime");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);

        String endDate= body.get("endDateTime");
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);

        int student_id = Integer.parseInt(body.get("student_id"));
        int course_id = Integer.parseInt(body.get("course_id"));

        ScoreInfo save = scoreRepository.save(new ScoreInfo(score, startDateTime, endDateTime, student_id, course_id));
        return save;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update/scores/{id}")
    public ResponseEntity<ScoreInfo> updateScore(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody Map<String, String> body) throws ResourceNotFoundException {
        int scoreID = Integer.parseInt(id);

        ScoreInfo scoreInfo = scoreRepository.findById(scoreID)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found for this id : " + scoreID));

        int score = Integer.parseInt(body.get("score"));

        String startDate = body.get("startDateTime");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);

        String endDate= body.get("endDateTime");
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);

        int student_id = Integer.parseInt(body.get("student_id"));
        int course_id = Integer.parseInt(body.get("course_id"));

        scoreInfo.setScore(score);
        scoreInfo.setStartDateTime(startDateTime);
        scoreInfo.setEndDateTime(endDateTime);
        scoreInfo.setCourse_id(course_id);
        scoreInfo.setStudent_id(student_id);
        final ScoreInfo updatedScore = scoreRepository.save(scoreInfo);
        return ResponseEntity.ok(updatedScore);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "delete/scores/{id}")
    public Map<String, Boolean> deleteScore(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        int scoreID = Integer.parseInt(id);
        ScoreInfo scoreInfo = scoreRepository.findById(scoreID)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found for this id : " + scoreID));

        scoreRepository.delete(scoreInfo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Score with id " +scoreID+ " is deleted", Boolean.TRUE);
        return response;
    }


}
