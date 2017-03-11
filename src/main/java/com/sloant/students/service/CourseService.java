package com.sloant.students.service;

import com.sloant.students.domain.Course;
import com.sloant.students.domain.Student;

import java.util.List;

/**
 * Created by Tim Sloan
 */
public interface CourseService {

    List<Course> getAllCourses();
    void updateCourses(List<Course> courses);
    void addCourse(int id, String name, String description);
    List<Student> getStudentsOnCourse(int courseId);
    void deleteCourse(int courseId);
    void enrollInCourse(int studentId, int courseId);
}
