package com.sloant.students.service;

import com.sloant.students.domain.Course;
import com.sloant.students.domain.Student;

import java.util.List;

/**
 * Created by Tim Sloan
 */
public interface StudentService {

    List<Student> getAllStudents();
    void updateStudents(List<Student> students);
    void addStudent(int id, String firstName, String lastName);
    Student getStudent(int id);
    List<Course> getStudentEnrolledCourses(int studentId);
    void enrollInCourse(int studentId, int courseId);
    void leaveCourse(int studentId, int courseId);
}
