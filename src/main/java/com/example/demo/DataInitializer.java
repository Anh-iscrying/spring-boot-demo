package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired private DepartmentRepository deptRepo;
    @Autowired private InstructorRepository insRepo;
    @Autowired private CourseRepository courseRepo;
    @Autowired private StudentRepository stuRepo;

    @Override
    public void run(String... args) throws Exception {
        // 1. Tạo Phòng ban
        Department itDept = new Department("IT", "Toà nhà A1", null, null);
        deptRepo.save(itDept);

        // 2. Tạo Giảng viên
        Instructor teacher = new Instructor(null, "Truong Khoa", "Nguyen", "Van A", "0909123456", itDept, null);
        insRepo.save(teacher);

        // 3. Tạo Sinh viên
        Student s1 = new Student(null, "Teo", "Nguyen", "0123", null);
        Student s2 = new Student(null, "Ty", "Le", "0456", null);
        stuRepo.saveAll(Arrays.asList(s1, s2));

        // 4. Tạo Khóa học và gán Sinh viên vào
        Course javaCourse = new Course(null, "Lập trình Spring Boot", 40, itDept, teacher, Arrays.asList(s1, s2));
        courseRepo.save(javaCourse);

        System.out.println(">> Đã bơm dữ liệu mẫu thành công!");
    }
}