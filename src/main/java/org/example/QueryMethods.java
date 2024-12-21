package org.example;

import java.sql.*;
import java.util.LinkedList;

public class QueryMethods {

    Connection conn;
//    jdbc:postgresql://localhost:5432/mydatabase
    private void connect() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBCPractice","postgres", "KoushiK11@");
    }

    public void addStudent(String name){
        String sql = "INSERT INTO students (name) VALUES (?)";

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            System.out.println("Successfully added student");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    };

    public LinkedList<Student> getStudents(){

        LinkedList<Student> students = new LinkedList<>();
        String sql = "SELECT * FROM students";

        try {
            connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                int rollNo = rs.getInt("rollno");
                Student s = new Student(rollNo, name);
                students.add(s);
            }

            conn.close();
            return students;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Student getStudent(int rollNo){
        String sql = "SELECT * FROM students WHERE rollno = ?";
        Student s = new Student(rollNo);

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rollNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                s.Name = name;
            }
            rs.close();
            pstmt.close();
            conn.close();
            return s;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return s;
    }

    public void updateStudent(int i, String name) {
        String sql = "UPDATE students SET name = ? WHERE rollno = ?";

        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, i);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            System.out.println("Successfully updated student");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteStudent(int rollNo) {
        String sql = "DELETE FROM STUDENTS WHERE rollno = ?";
        try {
            connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rollNo);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            System.out.println("Successfully deleted student");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
