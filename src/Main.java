import com.student.manage.DatabaseManager;
import com.student.manage.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;


import com.student.manage.StudentDatabase;

public class Main {
    public static void main(String[] args) throws IOException {

        final Connection ignored = DatabaseManager.getConnection();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to Add a new Student");
            System.out.println("Press 2 to Delete a Student");
            System.out.println("Press 3 to Display a Student");
            System.out.println("Press 4 to Update a Student");
            System.out.println("Press 5 Search a Student by ID");
            System.out.println("Press 6 to Exit");

            try {
                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter Student Name");
                        String studentName = br.readLine();
                        System.out.println("Enter Student Phone");
                        String studentPhone = br.readLine();
                        System.out.println("Enter Student City");
                        String studentCity = br.readLine();

                        Student st = new Student(studentName, studentPhone, studentCity);
                        boolean answer = StudentDatabase.insertStudentToDb(st);

                        if (answer) {
                            System.out.println("Student Added Successfully");
                        } else {
                            System.out.println("Something went wrong");
                        }
                        break;

                    case 2:
                        System.out.println("Enter Student ID to Delete");
                        int studentIdToDelete = Integer.parseInt(br.readLine());

                        boolean deleteAnswer = StudentDatabase.deleteStudent(studentIdToDelete);
                        if (deleteAnswer) {
                            System.out.println("Student Deleted Successfully");
                        } else {
                            System.out.println("Something went wrong");
                        }
                        break;

                    case 3:
                        StudentDatabase.showAllStudent();
                        break;

                    case 4:
                        System.out.println("Enter Student ID to Update");
                        int studentIdToUpdate = Integer.parseInt(br.readLine());
                        System.out.println("Enter Student Name");
                        String updatedStudentName = br.readLine();
                        System.out.println("Enter Student Phone");
                        String updatedStudentPhone = br.readLine();
                        System.out.println("Enter Student City");
                        String updatedStudentCity = br.readLine();

                        Student studentToUpdate = new Student(studentIdToUpdate, updatedStudentName, updatedStudentPhone, updatedStudentCity);
                        boolean updateAnswer = StudentDatabase.updateStudent(studentToUpdate);

                        if (updateAnswer) {
                            System.out.println("Student Updated Successfully");
                        } else {
                            System.out.println("Something went wrong");
                        }
                        break;

                    case 5:
                        System.out.println("Enter Student ID to Search");
                        int studentIdToSearch = Integer.parseInt(br.readLine());
                        StudentDatabase.searchStudent(studentIdToSearch);
                        break;
                    case 6:
                        // Exit
                        DatabaseManager.closeConnection();
                        System.out.println("Exit");
                        return;

                    default:
                        System.out.println("Invalid input. Please enter a valid number.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IOException e) {
                e.printStackTrace(); // Handle IOException as needed
            }
        }
    }
}
