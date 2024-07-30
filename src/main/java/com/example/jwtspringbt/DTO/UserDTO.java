package com.example.jwtspringbt.DTO;


import com.example.jwtspringbt.model.User;

import java.time.format.DateTimeFormatter;

public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password; // Tambahkan field password

    private String createdAt;

    // Default constructor
    public UserDTO() {
    }

    // All-args constructor
    public UserDTO(Integer id, String firstName, String lastName, String username, String email, String password, String createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password; // Tambahkan password ke konstruktor

        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    // Method to convert User to UserDTO while hiding token
    public static UserDTO fromUser(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(), // Ambil password dari User

                user.getCreatedAt() != null ? user.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) : null
        );
    }
}