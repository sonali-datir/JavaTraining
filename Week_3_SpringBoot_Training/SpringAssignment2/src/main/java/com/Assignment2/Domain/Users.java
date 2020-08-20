package com.Assignment2.Domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class Users {

    @NotNull
    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="ID should have at least 3 characters")
    private String id;

    @NotNull
    private String name;

    @NotNull
    @Pattern(regexp="^[a-zA-Z0-9]{9}", message="Passport should have 9 characters")
    private String passportNumber;

    public Users() {
    }

    public Users(String id, String name, String passportNumber) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
