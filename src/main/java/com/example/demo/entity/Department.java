package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "department") // Tên bảng trong MySQL
@Data // Tự tạo Getter, Setter, toString... (của Lombok)
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @Column(name = "Name", length = 255)
    private String name; // Trong ERD, Name là khóa chính

    @Column(name = "Location", length = 255)
    private String location;

    // Mối quan hệ 1 phòng ban có nhiều giảng viên
    @JsonIgnore 
    @OneToMany(mappedBy = "department")
    private List<Instructor> instructors;

    // Mối quan hệ 1 phòng ban có nhiều khóa học
    @JsonIgnore 
    @OneToMany(mappedBy = "department")
    private List<Course> courses;
}