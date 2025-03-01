import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();
        students.add(new Student(id, name, grade));
        System.out.println("Student added successfully!\n");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!\n");
            return;
        }
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println("ID: " + student.id + ", Name: " + student.name + ", Grade: " + student.grade);
        }
        System.out.println();
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.id == id) {
                System.out.println("Student Found - ID: " + student.id + ", Name: " + student.name + ", Grade: " + student.grade + "\n");
                return;
            }
        }
        System.out.println("Student not found!\n");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.id == id) {
                students.remove(student);
                System.out.println("Student removed successfully!\n");
                return;
            }
        }
        System.out.println("Student not found!\n");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }
}
