package lab1StudentManagement;

import lab1StudentManagement.service.StudentService;

import static lab1StudentManagement.service.UIService.printWelcomeScreen;
import static utils.integerUtils.getIntFromUser;

public class StudentManagementController {
    private final StudentService studentService;

    public StudentManagementController() {
        studentService = new StudentService();
    }

    public void run() {
        while (true) {
            try {
                printWelcomeScreen();
                int optionNumber = getIntFromUser("Please choose which function you want to do by input the number from 1.. 5 ",
                        "Please enter a valid integer");
                switch (optionNumber) {
                    case 1:
                        studentService.addStudent();
                        break;
                    case 2:
                        studentService.findStudentsByNameSortAndPrint();
                        break;
                    case 3:
                        studentService.updateOrDeleteStudent();
                        break;
                    case 4:
                        studentService.report();
                        break;
                    case 5:
                        System.out.println("See you!");
                        return;
                    default:
                        System.out.println("Please try again!");
                }
            } catch (Exception e) {
                System.out.println("Ops.... \n" + e);
            }
        }
    }
}
