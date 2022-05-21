package lab1StudentManagement;

import java.util.ArrayList;

import static lab1StudentManagement.uiService.printWelcomeScreen;
import static utils.integerUtils.getIntFromUser;
import static utils.stringUtils.getStringFromUser;

public class StudentManagementController {
    public void run() {
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            printWelcomeScreen();
            int userInput = getIntFromUser("Please choose which function you want to do by input the number from 1.. 5",
                    "Please enter a valid integer");
            switch (userInput) {
                case 1:
                    addStudent(studentList);
                    break;
                case 2:
                    findStudentByName(studentList);
                    break;
                case 3:
                    updateOrDeleteStudent(studentList);
                    break;
                case 4:
                    report(studentList);
                    break;
                case 5:
                    System.out.println("See you!");
                    return;
                default:
                    System.out.println("Please try again!");
            }
        }
    }

    private void addStudent(ArrayList<Student> studentList) {
        int count = 0;
        boolean isContinue = true;

        while (count < 10 || isContinue == true) {
            if (count >= 10) {
                isContinue = getStringFromUser("Do you want to continue? (Y/N)").toLowerCase() == "y" ? true : false;
            }

            Student student = new Student();
            student.setStudentName(getStringFromUser("Student name: "));
            student.setSemester(getIntFromUser("Semester: ", "Please input an integer!"));
            student.setCourseName(getStringFromUser("Course name: "));

            studentList.add(student);
        }
    }

    private void updateOrDeleteStudent(ArrayList<Student> studentList) {

    }

    private void findStudentByName(ArrayList<Student> studentList) {

    }

    private void report(ArrayList<Student> studentList) {

    }
}
