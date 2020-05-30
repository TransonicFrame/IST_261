package studentinfoapp;

import java.util.ArrayList;
import java.util.List;

public class StudentList {

    private final List<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return getStudentList().toString();
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
