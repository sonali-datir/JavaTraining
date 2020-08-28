package com.assignment3.controller;

import com.assignment3.domain.StudentInfo;
import com.assignment3.exception.ResourceNotFoundException;
import com.assignment3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/student")
    public List<StudentInfo> getAllStudents(){
        return studentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student/{id}")
    public ResponseEntity<StudentInfo> getStudentByID(@PathVariable (value="id") String studentID)
            throws ResourceNotFoundException {
        StudentInfo studentInfo = studentRepository.findById(Integer.parseInt(studentID))
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " +studentID + " not found "));

        return ResponseEntity.ok().body(studentInfo);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/student/getbyname")
    public List<StudentInfo> search(@RequestBody Map<String, String> body) throws ResourceNotFoundException{
        String searchTerm = body.get("text");
        return studentRepository.findByFirstName(searchTerm);
    }

    @RequestMapping(method = RequestMethod.POST, value = "create/student")
    public StudentInfo createStudent(@Valid @RequestBody Map<String, String> body){
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        return studentRepository.save(new StudentInfo(firstName, lastName));
    }


    @RequestMapping(method = RequestMethod.PUT, value = "update/student/{id}")
    public ResponseEntity<StudentInfo> updateStudent(@PathVariable(value = "id") String id,
                                           @Valid @RequestBody Map<String, String> body) throws ResourceNotFoundException {
        int studentID = Integer.parseInt(id);
        // getting blog
        StudentInfo studentInfo = studentRepository.findById(studentID)
                 .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id : " + studentID));
        studentInfo.setFirstName(body.get("firstName"));
        studentInfo.setLastName(body.get("lastName"));
        final StudentInfo updatedStudent = studentRepository.save(studentInfo);
        return ResponseEntity.ok(updatedStudent);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/student/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        int studentID = Integer.parseInt(id);
        StudentInfo student = studentRepository.findById(studentID)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id : " + studentID));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Student with id " +studentID+ " is deleted", Boolean.TRUE);
        return response;
    }
}
