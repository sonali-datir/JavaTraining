package com.assignment3.controller;

import com.assignment3.domain.CourseInfo;
import com.assignment3.domain.StudentInfo;
import com.assignment3.exception.ResourceNotFoundException;
import com.assignment3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/course")
    public List<CourseInfo> getAllCourses(){
        return courseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/course/{id}")
    public ResponseEntity<CourseInfo> getCourseByID(@PathVariable(value="id") String courseID)
            throws ResourceNotFoundException {
        CourseInfo courseInfo = courseRepository.findById(Integer.parseInt(courseID))
                .orElseThrow(() -> new ResourceNotFoundException("Course with id " +courseID + " not found "));

        return ResponseEntity.ok().body(courseInfo);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/course/getbyname")
    public List<CourseInfo> search(@RequestBody Map<String, String> body) throws ResourceNotFoundException{
        String searchTerm = body.get("text");
        return courseRepository.findByCourseName(searchTerm);
    }

    @RequestMapping(method = RequestMethod.POST, value = "create/course")
    public CourseInfo createCourse(@Valid @RequestBody Map<String, String> body){
        String courseName = body.get("courseName");
        return courseRepository.save(new CourseInfo(courseName));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update/course/{id}")
    public ResponseEntity<CourseInfo> updateCourse(@PathVariable(value = "id") String id,
                                                     @Valid @RequestBody Map<String, String> body) throws ResourceNotFoundException {
        int courseID = Integer.parseInt(id);
        // getting blog
        CourseInfo courseInfo = courseRepository.findById(courseID)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id : " + courseID));
        courseInfo.setCourseName(body.get("courseName"));

        final CourseInfo updatedCourse = courseRepository.save(courseInfo);
        return ResponseEntity.ok(updatedCourse);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/course/{id}")
    public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        int courseID = Integer.parseInt(id);
        CourseInfo courseInfo = courseRepository.findById(courseID)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id : " + courseID));

        courseRepository.delete(courseInfo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Course with id " +courseID+ " is deleted", Boolean.TRUE);
        return response;
    }

}
