package com.sloant.students.domain.repository.impl;

import com.sloant.students.domain.Course;
import com.sloant.students.domain.Student;
import com.sloant.students.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim Sloan
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    private DataSource mysqlPoolableDataSource;

    @Override
    public List<Student> getAllStudents() {
        List<Student> results = new ArrayList<>();
        final String sql = "SELECT * FROM STUDENTS";
        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getInt("ID"));
                results.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //no need for finally block as we are using try-with-resources. Resources automatically cleaned-up, and connection returned
        //to pool
        return results;
    }

    @Override
    public void updateStudent(int id, String firstName, String lastName) {
        final String sql = "UPDATE STUDENTS SET FIRSTNAME=?, LASTNAME=? WHERE ID =?";

        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(int id, String firstName, String lastName) {
        final String sql = "INSERT INTO STUDENTS VALUES(?,?,?)";

        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudent(int id) {
        final String sql = "SELECT * from STUDENTS WHERE ID = ?";
        Student result = null;
        try(Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = new Student(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getInt("ID"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Course> getStudentEnrolledCourses(int studentId) {
        final String sql = "SELECT STUDENT_COURSE.COURSEID, COURSES.NAME, COURSES.DESCRIPTION " +
                "from student_reg.STUDENT_COURSE " +
                "  INNER JOIN student_reg.COURSES " +
                "    ON STUDENT_COURSE.COURSEID = COURSES.ID " +
                "WHERE STUDENT_COURSE.STUDENTID = ?";
        List<Course> results = new ArrayList<>();
        try(Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(new Course(rs.getInt("COURSEID"), rs.getString("NAME"),rs.getString("DESCRIPTION")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public void enrollInCourse(int studentId, int courseId) {
        final String sql = "INSERT INTO STUDENT_COURSE VALUES (?,?)";

        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leaveCourse(int studentId, int courseId) {
        final String sql = "DELETE FROM STUDENT_COURSE WHERE STUDENTID=? AND COURSEID=?";
        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
