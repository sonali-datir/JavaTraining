package com.assignment3.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "course_info")
public class CourseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    private String courseName;

//    @OneToMany(mappedBy = "course_info", cascade = {
//            CascadeType.ALL
//    })
//    private ScoreInfo scoreInfoList;

    public CourseInfo() {
    }

    public CourseInfo(int id, @NotNull @Size(max = 100) String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public CourseInfo(@NotNull @Size(max = 100) String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
