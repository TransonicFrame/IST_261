package mvcapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {

    private final ArrayList<Student> studentList;

    public StudentList() throws FileNotFoundException {
        studentList = new ArrayList<>();
        populateArraylist();
    }

    private void populateArraylist() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("studentInfo.txt"));
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] dataArray = data.split(", ");
            studentList.add(new Student(dataArray[0], dataArray[1], dataArray[2], Double.parseDouble(dataArray[3])));
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}
