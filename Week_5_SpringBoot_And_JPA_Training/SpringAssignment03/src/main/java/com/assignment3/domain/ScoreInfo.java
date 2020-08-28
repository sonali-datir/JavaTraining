package com.assignment3.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "score_info")
public class ScoreInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotNull
//    @Size(max = 10)
//    private int studentId;
//
//    @NotNull
//    @Size(max = 10)
//    private int courseId;

    @NotNull
    private int score;

    @NotNull
    private LocalDateTime startDateTime;


    @NotNull
    private LocalDateTime endDateTime;

    @NotNull
    private int student_id;

    @NotNull
    private int course_id;

    public ScoreInfo() {
    }

    public ScoreInfo(@NotNull @Size(max = 10) int score, @NotNull LocalDateTime startDateTime,
                     @NotNull LocalDateTime endDateTime, @NotNull int student_id,
                     @NotNull int course_id) {
        this.score = score;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public ScoreInfo(int id, @NotNull @Size(max = 10) int score, @NotNull LocalDateTime startDateTime,
                     @NotNull LocalDateTime endDateTime,
                     @NotNull int student_id, @NotNull int course_id) {
        this.id = id;
        this.score = score;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

}
