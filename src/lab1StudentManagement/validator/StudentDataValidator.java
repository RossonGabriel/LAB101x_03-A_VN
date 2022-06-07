package lab1StudentManagement.validator;

import lab1StudentManagement.model.Student;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.constant.VALID_COURSE_NAMES;

public class StudentDataValidator {
    public static boolean isValidStudentId(String studentId, ArrayList<Student> studentList) {
        return studentList.stream().noneMatch((student -> student.getId().equalsIgnoreCase(studentId)));
    }

    public static boolean isValidCourseName(String courseName) {
        return Arrays.stream(VALID_COURSE_NAMES).anyMatch(elm -> elm.equalsIgnoreCase(courseName));
    }
}
