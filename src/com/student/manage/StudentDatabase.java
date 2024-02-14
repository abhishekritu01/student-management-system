package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class StudentDatabase {
    public static boolean insertStudentToDb(Student st) {
        try {
            // JDBC Code
            String query = "insert into students(sname,sphone,scity) values(?,?,?)";

            final Connection connection = DatabaseManager.getConnection();
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, st.getStudentName());
                pstmt.setString(2, st.getStudentPhone());
                pstmt.setString(3, st.getStudentCity());
                pstmt.executeUpdate();
            } catch (final SQLException ex) {
                System.out.println("Failed to set values in prepared statement : " + ex.getMessage());
                return false;
            }
        } catch (final Exception exception) {
            System.out.println("Failed to insert student : " + exception.getMessage());
            return false;
        }
        return true;
    }

    public static boolean deleteStudent(int studentId) {
        try {
            // JDBC Code
            String query = "delete from students where sid=?";

            final Connection connection = DatabaseManager.getConnection();
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, studentId);
                pstmt.executeUpdate();
            } catch (final SQLException ex) {
                System.out.println("Failed to set values in prepared statement : " + ex.getMessage());
                return false;
            }
        } catch (final Exception exception) {
            System.out.println("Failed to delete student : " + exception.getMessage());
            return false;
        }
        return true;
    }

    public static void showAllStudent() {
        try {
            // JDBC Code
            String query = "select * from students";

            final Connection connection = DatabaseManager.getConnection();
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        // Retrieve and display student details
                        int studentId = resultSet.getInt("sid");
                        String studentName = resultSet.getString("sname");
                        // Add more fields as needed

                        System.out.println("Student ID: " + studentId);
                        System.out.println("Student Name: " + studentName);
                        System.out.println("Student Phone: " + resultSet.getString("sphone"));
                        System.out.println("Student City: " + resultSet.getString("scity"));
                        // Print other details

                        System.out.println("--------------------------");
                    }
                } catch (SQLException ex) {
                    System.out.println("Failed to process result set : " + ex.getMessage());
                }
            } catch (SQLException ex) {
                System.out.println("Failed to execute query : " + ex.getMessage());
            }
        } catch (Exception exception) {
            System.out.println("Failed to show student : " + exception.getMessage());
        }
    }

    public static boolean updateStudent(Student st) {
        try {
            // JDBC Code
            String query = "update students set sname=?,sphone=?,scity=? where sid=?";

            final Connection connection = DatabaseManager.getConnection();
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, st.getStudentName());
                pstmt.setString(2, st.getStudentPhone());
                pstmt.setString(3, st.getStudentCity());
                pstmt.setInt(4, st.getStudentId());
                pstmt.executeUpdate();
            } catch (final SQLException ex) {
                System.out.println("Failed to set values in prepared statement : " + ex.getMessage());
                return false;
            }
        } catch (final Exception exception) {
            System.out.println("Failed to update student : " + exception.getMessage());
            return false;
        }
        return true;
    }

    public static void InvalidInput() {
        try {
            System.out.println("Invalid Input");
        } catch (Exception exception) {
            System.out.println("Failed to show student : " + exception.getMessage());
        }
    }

    public static void searchStudent(int studentIdToSearch){
        try {
            // JDBC Code
            String query = "select * from students where sid=?";

            final Connection connection = DatabaseManager.getConnection();
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, studentIdToSearch);
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        // Retrieve and display student details
                        int studentId = resultSet.getInt("sid");
                        String studentName = resultSet.getString("sname");
                        // Add more fields as needed

                        System.out.println("Student ID: " + studentId);
                        System.out.println("Student Name: " + studentName);
                        System.out.println("Student Phone: " + resultSet.getString("sphone"));
                        System.out.println("Student City: " + resultSet.getString("scity"));
                        // Print other details

                        System.out.println("--------------------------");
                    }
                } catch (SQLException ex) {
                    System.out.println("Failed to process result set : " + ex.getMessage());
                }
            } catch (SQLException ex) {
                System.out.println("Failed to execute query : " + ex.getMessage());
            }
        } catch (Exception exception) {
            System.out.println("Failed to show student : " + exception.getMessage());
        }
    }
}
