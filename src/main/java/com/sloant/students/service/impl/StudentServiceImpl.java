package com.sloant.students.service.impl;

import com.sloant.students.domain.Course;
import com.sloant.students.domain.Student;
import com.sloant.students.domain.repository.StudentRepository;
import com.sloant.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tim Sloan
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    @Override
    public void updateStudents(List<Student> students) {
        for (Student student : students) {
            repository.updateStudent(student.getStudentId(), student.getFirstName(), student.getLastName());
        }
    }

    @Override
    public void addStudent(int id, String firstName, String lastName) {
        repository.addStudent(id, firstName, lastName);
    }

    @Override
    public Student getStudent(int id) {
        return repository.getStudent(id);
    }

    @Override
    public List<Course> getStudentEnrolledCourses(int studentId) {
        return repository.getStudentEnrolledCourses(studentId);
    }

    @Override
    public void enrollInCourse(int studentId, int courseId) {
        repository.enrollInCourse(studentId, courseId);
    }

    @Override
    public void leaveCourse(int studentId, int courseId) {
        repository.leaveCourse(studentId, courseId);
    }
}
