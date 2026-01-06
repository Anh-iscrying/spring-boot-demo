package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String firstName;
    private String lastName;
    private String phone;

    // Nhiều sinh viên học nhiều khóa học
    @JsonIgnore 
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}