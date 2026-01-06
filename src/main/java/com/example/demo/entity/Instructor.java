package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "instructor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String headedBy;
    private String firstName;
    private String lastName;
    private String phone;

    // Nhiều giảng viên thuộc về 1 phòng ban
    @ManyToOne
    @JoinColumn(name = "DepartmentName") // Khóa ngoại liên kết với PK của Department
    private Department department;

    // Một giảng viên có thể dạy nhiều khóa học
    @JsonIgnore 
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;
}