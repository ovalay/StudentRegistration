package com.sloant.students.domain.repository;

import com.sloant.students.domain.Course;
import com.sloant.students.domain.Student;

import java.util.List;

/**
 * Created by Tim Sloan
 */
public interface CourseRepository {

    List<Course> getAllCourses();

    void updateCourse(int courseId, String courseName, String courseDescription);

    void addCourse(int courseId, String courseName, String courseDescription);

    List<Student> getStudentsOnCourse(int courseId);

    void deleteCourse(int courseId);

    void enrollInCourse(int studentId, int courseId);
}
