package com.c2c.backend_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.c2c.backend_java.model.Student;
import com.c2c.backend_java.model.User;
import com.c2c.backend_java.repository.StudentRepository;
import com.c2c.backend_java.repository.UserRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository,
                          UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public Student createStudent(Long userId, Student student) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (studentRepository.findByUserId(userId).isPresent()) {
            throw new RuntimeException("Student profile already exists");
        }

        student.setUser(user);

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student getStudentByUserId(Long userId) {
        return studentRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);

        existingStudent.setInstitution(updatedStudent.getInstitution());
        existingStudent.setCourse(updatedStudent.getCourse());
        existingStudent.setBranch(updatedStudent.getBranch());
        existingStudent.setYearOfStudy(updatedStudent.getYearOfStudy());
        existingStudent.setCgpa(updatedStudent.getCgpa());
        existingStudent.setResumeUrl(updatedStudent.getResumeUrl());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }

        studentRepository.deleteById(id);
    }
}