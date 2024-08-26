import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceManagementSystem {
    private List<Student> students;

    public AttendanceManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(int id, String name) {
        students.add(new Student(id, name));
    }

    public void markAttendance(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.markPresent();
                System.out.println("Attendance marked for " + student.getName());
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void displayAttendance() {
        System.out.println("Attendance Records:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        AttendanceManagementSystem system = new AttendanceManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding some students
        system.addStudent(1, "Alice");
        system.addStudent(2, "Bob");
        system.addStudent(3, "Charlie");

        while (true) {
            System.out.println("\nAttendance Management System");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Display Attendance");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID to mark attendance: ");
                    int id = scanner.nextInt();
                    system.markAttendance(id);
                    break;
                case 2:
                    system.displayAttendance();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
