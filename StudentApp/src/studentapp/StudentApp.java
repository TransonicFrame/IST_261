package studentapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "studentInfo.txt";
        List<Student> studentList = addStudentsToList(fileName);
        System.out.println(studentList);
    }

    private static List<Student> addStudentsToList(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Student> studentList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (data.contains(",")) {
                Student student = new Student(data.substring(0, data.indexOf(",")), data.substring(data.indexOf(" ") + 1, data.lastIndexOf(",")), Double.parseDouble(data.substring(data.lastIndexOf(" ") + 1, data.length())));
                studentList.add(student);
            }
        }
        return studentList;
    }
}
