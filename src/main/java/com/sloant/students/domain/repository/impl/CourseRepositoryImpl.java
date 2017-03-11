package com.sloant.students.domain.repository.impl;

import com.sloant.students.domain.Course;
import com.sloant.students.domain.Student;
import com.sloant.students.domain.repository.CourseRepository;
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
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private DataSource mysqlPoolableDataSource;

    @Override
    public List<Course> getAllCourses() {
        List<Course> results = new ArrayList<>();
        final String sql = "SELECT * FROM COURSES";
        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);){
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                results.add(new Course(rs.getInt("ID"), rs.getString("NAME"), rs.getString("DESCRIPTION")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //no need for finally block as we are using try-with-resources. Resources automatically cleaned-up
        return results;
    }

    @Override
    public void updateCourse(int courseId, String courseName, String courseDescription) {
        final String sql = "UPDATE COURSES SET NAME=?, DESCRIPTION=? WHERE ID=?";

        try (Connection con = mysqlPoolableDataSource.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, courseName);
            ps.setString(2, courseDescription);
            ps.setInt(3, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Again, no need for finally block as we are using try-with-resources. Resources automatically cleaned-up
    }

    @Override
    public void addCourse(int courseId, String courseName, String courseDescription) {
        final String sql = "INSERT INTO COURSES VALUES(?, ?, ?)";
        try(Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ps.setString(2, courseName);
            ps.setString(3, courseDescription);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getStudentsOnCourse(int courseId) {
        //inner join to get access to student name details too
        final String sql = "SELECT STUDENT_COURSE.STUDENTID, STUDENTS.FIRSTNAME, STUDENTS.LASTNAME " +
                "from student_reg.STUDENT_COURSE " +
                "  INNER JOIN student_reg.STUDENTS " +
                "    ON STUDENT_COURSE.STUDENTID = STUDENTS.ID " +
                "WHERE STUDENT_COURSE.COURSEID = ?";
        List<Student> results = new ArrayList<>();
        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(new Student(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getInt("STUDENTID")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public void deleteCourse(int courseId) {
        final String sql = "DELETE FROM COURSES WHERE ID=?";

        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enrollInCourse(int studentId, int courseId) {
        final String sql = "INSERT INTO STUDENT_COURSE VALUES (?, ?)";

        try (Connection con = mysqlPoolableDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
