package lab1StudentManagement;

public class Student {
    private int id;
    private String studentName;
    private int semester;
    private String courseName;

    private static int idCounter = 0;

    public Student() {
        this.id = ++idCounter;
    }

    public int getId() {
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void showInfo() {
        System.out.println("");
    }
}
