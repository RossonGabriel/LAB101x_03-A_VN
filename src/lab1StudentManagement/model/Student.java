package lab1StudentManagement.model;

import java.util.ArrayList;

public class Student {
    private
    String id;
    private String studentName;
    private int semester;
    private ArrayList<String> courseName;

    public Student(String id, String studentName, int semester, ArrayList<String> courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<String> getCourseName() {
        return courseName;
    }

    public void setCourseName(ArrayList<String> courseName) {
        this.courseName = courseName;
    }

    public void showInfo() {
        System.out.printf("|%10s|%20s|%10d|%20s|\n", id, studentName, semester, courseName);
    }


}
