package com.example.viiko_10;

import java.io.Serializable;
import java.util.List;

public class User  implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private List<String> degrees;

    public User(String firstName, String lastName, String email, String degreeProgram, List<String> degrees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }
    public List<String> getDegrees() {
        return degrees;
    }
}
