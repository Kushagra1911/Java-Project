package com.srm.dao;

import com.srm.model.Student;
import com.srm.util.DBConnection;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    Connection con = DBConnection.getConnection();

    public boolean addStudent(Student s) {
        String q = "INSERT INTO students VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateStudent(Student s) {
        String q = "UPDATE students SET name=?, course=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setInt(3, s.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
