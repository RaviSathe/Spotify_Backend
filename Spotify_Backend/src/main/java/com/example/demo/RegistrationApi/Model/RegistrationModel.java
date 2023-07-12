package com.example.demo.RegistrationApi.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "User")
public class RegistrationModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long registerId;
    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String email;
    private String password;
    private String role;
}