package com.nhnacademy.edu.springboot.student.service;

import com.nhnacademy.edu.springboot.student.domain.Student;
import com.nhnacademy.edu.springboot.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhnStudentService implements StudentService{
    private final StudentRepository studentRepository;

    //생성자 주입방식
    public NhnStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
