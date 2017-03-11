package com.sloant.students.service.impl;

import com.sloant.students.domain.Course;
import com.sloant.students.domain.Student;
import com.sloant.students.domain.repository.CourseRepository;
import com.sloant.students.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tim Sloan
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public void updateCourses(List<Course> coursesToUpdate) {
        for (Course course : coursesToUpdate) {
            courseRepository.updateCourse(course.getCourseId(), course.getName(), course.getDescription());
        }
    }

    @Override
    public List<Student> getStudentsOnCourse(int courseId) {
        return courseRepository.getStudentsOnCourse(courseId);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteCourse(courseId);
    }

    @Override
    public void enrollInCourse(int studentId, int courseId) {
        courseRepository.enrollInCourse(studentId, courseId);
    }

    @Override
    public void addCourse(int id, String name, String description) {
        courseRepository.addCourse(id, name, description);
    }
}
