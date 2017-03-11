package com.sloant.students.controller;

import com.sloant.students.domain.Student;
import com.sloant.students.service.StudentService;
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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String list(Model model) {

        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @RequestMapping("/details")
    public String getStudentDetails(@RequestParam("studentId") int studentId, Model model) {
        model.addAttribute("student", studentService.getStudent(studentId));
        return "studentDetails";
    }

    @RequestMapping("/studentCourses")
    public String getStudentCourses(@RequestParam("studentId") int studentId, Model model) {
        model.addAttribute("studentid", studentId);
        model.addAttribute("enrolledCourses", studentService.getStudentEnrolledCourses(studentId));
        return "studentCourses";
    }

    @RequestMapping("/leaveCourse")
    public String leaveCourse(@RequestParam("courseid") int courseId, @RequestParam("studentId") int studentid, Model model) {
        studentService.leaveCourse(studentid, courseId);
        return "redirect:/students/studentCourses?studentId="+studentid;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewStudentForm(Model model) {
        Student newStudent = new Student();
        model.addAttribute("newStudent", newStudent);
        return "addStudent";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewStudentForm(@ModelAttribute("newStudent")
                                     Student newStudent) {
        studentService.addStudent(newStudent.getStudentId(), newStudent.getFirstName(), newStudent.getLastName());
        return "redirect:/students/list";
    }
}
