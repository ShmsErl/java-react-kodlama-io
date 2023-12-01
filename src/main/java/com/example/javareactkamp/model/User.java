package com.example.javareactkamp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Email
    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "password")
    private String password;
}
