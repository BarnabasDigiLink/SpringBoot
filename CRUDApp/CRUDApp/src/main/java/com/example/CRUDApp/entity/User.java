package com.example.CRUDApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usertable")
public class User {
    @Id
    @GeneratedValue
    //user attributes
    private int id;
    private String name;
    private String address;
    private String position;
    private String password;
}
