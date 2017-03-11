package com.sloant.students.controller;

import com.sloant.students.domain.Course;
import com.sloant.students.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Tim Sloan
 */
@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewCourseForm(Model model) {
        Course newCourse = new Course();
        model.addAttribute("newCourse", newCourse);
        return "addCourse";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewStudentForm(@ModelAttribute("newCourse") Course newCourse) {
        courseService.addCourse(newCourse.getCourseId(), newCourse.getName(), newCourse.getDescription());
        return "redirect:/courses/list";
    }

    @RequestMapping("enrolledStudents")
    public String getEnrolledStudentsForCourse(@RequestParam("courseId") int courseId, Model model) {
        model.addAttribute("students", courseService.getStudentsOnCourse(courseId));
        model.addAttribute("courseId", courseId);
        return "courseEnrolledStudents";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("courseId") int courseId, Model model) {
        courseService.deleteCourse(courseId);
        return "redirect:/courses/list";
    }

    @RequestMapping("/enroll")
    public String enroll(@RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId, Model model) {
        courseService.enrollInCourse(studentId, courseId);
        return "redirect:/courses/list";
    }
}
