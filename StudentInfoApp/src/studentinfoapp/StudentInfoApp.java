package studentinfoapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentInfoApp {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("studentInfo.txt"));
        StudentList studentList = new StudentList();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if (data.contains(",") && !data.contains("\"")) {
                String[] dataArray = data.split(", ");
                String firstName = dataArray[0];
                String lastName = dataArray[1];
                Double gpa = Double.parseDouble(dataArray[2]);
                String[] phoneNumber = dataArray[3].split("-");
                int areaCode = Integer.parseInt(phoneNumber[0]);
                int prefix = Integer.parseInt(phoneNumber[1]);
                int lineNum = Integer.parseInt(phoneNumber[2]);
                String[] skills = dataArray[4].split("; ");
                studentList.getStudentList().add(new Student(firstName, lastName, gpa, new PhoneNumber(areaCode, prefix, lineNum), skills));
            }
        }
        System.out.println(studentList.getStudentList().toString());

        for (int i = 0; i < studentList.getStudentList().size(); i++) {
            System.out.println(studentList.getStudentList().get(i));
        }
    }
}
