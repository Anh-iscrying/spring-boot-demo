package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private Integer duration;

    // Khóa học thuộc về 1 phòng ban
    @ManyToOne
    @JoinColumn(name = "DepartmentName")
    private Department department;

    // Khóa học do 1 giảng viên dạy
    @ManyToOne
    @JoinColumn(name = "InstructorID")
    private Instructor instructor;

    // Mối quan hệ Nhiều-Nhiều với Student (Tự đẻ ra bảng trung gian Course_Student)
    @JsonIgnore 
    @ManyToMany
    @JoinTable(
        name = "course_student",
        joinColumns = @JoinColumn(name = "CourseID"),
        inverseJoinColumns = @JoinColumn(name = "StudentID")
    )
    private List<Student> students;
}