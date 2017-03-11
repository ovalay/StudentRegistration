package com.sloant.students.domain.repository;

import com.sloant.students.domain.Course;
import com.sloant.students.domain.Student;

import java.util.List;

/**
 * Created by Tim Sloan
 */

public interface StudentRepository {

    List<Student> getAllStudents();

    void updateStudent(int id, String firstName, String lastName);

    void addStudent(int id, String firstName, String lastName);

    Student getStudent(int id);

    List<Course> getStudentEnrolledCourses(int studentId);

    void enrollInCourse(int studentId, int courseId);

    void leaveCourse(int studentId, int courseId);
}
