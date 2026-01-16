package com.example.innovation.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public UserInfo() {
    }

    public UserInfo(int id, String password, String firstName, String username, String lastName, String roles) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.username = username;
        this.lastName = lastName;
        this.roles = roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    private String firstName;

    @Column(unique = true)
    private String username;

    private String lastName;

    private String roles;

    private String password;
}
