package lab1StudentManagement.service;

import lab1StudentManagement.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import static lab1StudentManagement.service.UIService.printStudentInfoHeader;
import static lab1StudentManagement.validator.StudentDataValidator.isValidCourseName;
import static lab1StudentManagement.validator.StudentDataValidator.isValidStudentId;
import static utils.constant.MAX_NUMBER_STUDENT_REQUIRED;
import static utils.constant.VALID_COURSE_NAMES;
import static utils.integerUtils.getIntFromUser;
import static utils.stringUtils.getStringFromUser;

public class StudentService {
    private final ArrayList<Student> studentList;

    public StudentService() {
        studentList = new ArrayList<>();
        studentList.add(new Student("S1", "Quang", 1, new ArrayList<>(Arrays.asList("Java", "Java", ".Net"))));
        studentList.add(new Student("S2", "Hieu", 7, new ArrayList<>(Arrays.asList("Java", ".Net"))));
        studentList.add(new Student("S3", "Ha", 1, new ArrayList<>(Arrays.asList("Java", "Java", ".Net"))));
        studentList.add(new Student("S4", "Huy", 7, new ArrayList<>(Arrays.asList("Java", "Java", ".Net"))));
        studentList.add(new Student("S5", "Mai", 1, new ArrayList<>(Arrays.asList("Java", ".Net"))));
        studentList.add(new Student("S6", "Dao", 7, new ArrayList<>(Arrays.asList("Java", "Java", ".Net"))));
        studentList.add(new Student("S7", "Teo", 1, new ArrayList<>(Arrays.asList("Java", "Java"))));
        studentList.add(new Student("S8", "Tin", 7, new ArrayList<>(Arrays.asList("Java", ".Net"))));
    }

    public void addStudent() {
        do {
            String studentId = getStudentIdFromUser();
            String studentName = getStringFromUser("Student name: ");
            int semester = getIntFromUser("Semester: ", "Please input an integer!");
            ArrayList<String> studentCourses = getStudentCoursesFromUser();

            studentList.add(new Student(studentId, studentName, semester, studentCourses));
        } while (isContinuedAddStudent());

        printStudentInfoHeader();
        studentList.forEach(Student::showInfo);
    }

    public void updateOrDeleteStudent() throws Exception {
        String studentID = getStringFromUser("Please input a student ID ");
        Student student = findStudentByID(studentID);
        if (student == null) throw new Exception("Student with id " + studentID + " is not found!");

        while (true) {
            String userInput = getStringFromUser("Do you want to update (U) or delete (D) this student ");

            if (userInput.equalsIgnoreCase("u")) {
                updateStudent(student);
                return;
            } else if (userInput.equalsIgnoreCase("d")) {
                deleteStudent(student);
                return;
            }

            System.out.println("Please input letter U or D");
        }
    }

    public void findStudentsByNameSortAndPrint() {
        String studentName = getStringFromUser("Please input a student name: ");
        printStudentInfoHeader();
        studentList.stream()
                .filter(student -> student.getStudentName().toLowerCase().contains(studentName.toLowerCase()))
                .sorted(Comparator.comparing(Student::getStudentName))
                .forEach(Student::showInfo);
    }

    public void report() {
        studentList.forEach(student -> {
            ArrayList<String> courseNames = student.getCourseName();
            ArrayList<String> courseNamesFilter = new ArrayList<>();

            courseNames.forEach(courseName -> {
                boolean isAlreadyCounted = courseNamesFilter.stream().anyMatch(elm -> elm.equalsIgnoreCase(courseName));

                if (!isAlreadyCounted) {
                    courseNamesFilter.add(courseName);
                    long amountOfCourses = courseNames.stream().filter((elm) -> elm.equalsIgnoreCase(courseName)).count();
                    System.out.printf("|%25s|%8s|%3d\n", student.getStudentName(), courseName, amountOfCourses);
                }
            });
        });
    }

    private String getStudentIdFromUser() {
        while (true) {
            String studentId = getStringFromUser("Student id: ");
            if (isValidStudentId(studentId, studentList)) return studentId;

            System.out.println("ID already existed!");
        }
    }

    private ArrayList<String> getStudentCoursesFromUser() {
        ArrayList<String> studentCourses = new ArrayList<>();
        boolean isContinue = true;

        while (isContinue) {
            String courseName = getStringFromUser("Course name: ");
            if (isValidCourseName(courseName)) {
                studentCourses.add(courseName);
                isContinue = getStringFromUser("Any other course? (Y/N) ").equalsIgnoreCase("y");
                continue;
            }
            System.out.println("Please input a valid course name: " + Arrays.toString(VALID_COURSE_NAMES));
        }

        return studentCourses;
    }

    private boolean isContinuedAddStudent() {
        if (studentList.size() >= MAX_NUMBER_STUDENT_REQUIRED) {
            return getStringFromUser("Continue adding student? (Y/N) ").equalsIgnoreCase("y");
        }
        return true;
    }

    private void updateStudent(Student student) {
        System.out.printf("Updating student with id %s...\n", student.getId());
        String updatedName = getStringFromUser("Student name: " + student.getStudentName() + " => ");
        int updateSemester = getIntFromUser("Semester: " + student.getSemester() + " => ", "Integer please!");
        System.out.print("Course name: " + student.getCourseName().toString() + "\n=> ");
        ArrayList<String> updatedStudentCourses = getStudentCoursesFromUser();

        student.setStudentName(updatedName);
        student.setSemester(updateSemester);
        student.setCourseName(updatedStudentCourses);
        System.out.println("Update successfully!");
        printStudentInfoHeader();
        student.showInfo();
    }

    private void deleteStudent(Student student) {
        if (studentList.remove(student)) {
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete fail. Please try again!");
        }
    }

    private Student findStudentByID(String studentID) {
        return studentList.stream().filter(student -> student.getId().equalsIgnoreCase(studentID))
                .findFirst()
                .orElse(null);
    }
}
