package com.assignment3.domain;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="student_info")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "FirstName cannot be null.")
    @Size(max = 100)
//    @Pattern(regexp="^[a-zA-Z]",
//            message="First Name should not contain numbers or special characters.")
    private String firstName;

    @NotNull(message = "Last Name cannot be null.")
    @Size(max = 250)
//    @Pattern(regexp="^[a-zA-Z]",
//            message="Last Name should not contain numbers or special characters.")
    private String lastName;

    public StudentInfo() {
    }

    public StudentInfo(int id, @NotNull @Size(max = 100) String firstName, @NotNull @Size(max = 250) String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public StudentInfo(@NotNull @Size(max = 100) String firstName, @NotNull @Size(max = 250) String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
