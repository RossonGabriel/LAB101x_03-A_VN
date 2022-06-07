package lab1StudentManagement.service;

public class UIService {
    public static void printWelcomeScreen() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT APPLICATION");
        System.out.println("1. Add New Student");
        System.out.println("2. Find And Sort");
        System.out.println("3. Update / Delete Info");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("");
    }

    public static void printStudentInfoHeader() {
        System.out.printf("|%10s|%20s|%10s|%20s|\n", "Student ID", "Student Name", "Semester", "Course Name");
    }
}
