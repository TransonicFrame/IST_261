package studentinfogsonapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.Arrays;

public class StudentInfoGsonApp {

    public static void main(String[] args) {
        String[] studentInfo = {"John, Doe, 3.1, 800-555-1212, Solidity",
            "Jane, Deere, 3.25, 898-555-1212, swimming;sleeping;dreaming;kayaking;",
            "Sam, Spade, 2.9, 888-555-1212, coffee-drinking;Java;Python"};

        StudentList students = new StudentList();
        for (String studentInfo1 : studentInfo) {
            String[] student = studentInfo1.split(", ");
            String[] phoneNumber = student[3].split("-");
            int areaCode = Integer.parseInt(phoneNumber[0]);
            int prefix = Integer.parseInt(phoneNumber[1]);
            int lineNum = Integer.parseInt(phoneNumber[2]);
            String[] skills = student[4].split(";");
            students.getStudentList().add(new Student(student[0], student[1], Double.parseDouble(student[2]), new PhoneNumber(areaCode, prefix, lineNum), skills));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String studentJSON = gson.toJson(students);

        System.out.println(studentJSON + "\n");
        StudentList studentJSONList = gson.fromJson(studentJSON, StudentList.class);

        JsonObject jane = new JsonObject();
        jane.addProperty("firstName", studentJSONList.getStudentList().get(1).getFirstName());
        jane.addProperty("lastName", studentJSONList.getStudentList().get(1).getLastName());
        jane.addProperty("areaCode", studentJSONList.getStudentList().get(1).getPhoneNumber().getAreaCode());
        jane.addProperty("skills", Arrays.toString(studentJSONList.getStudentList().get(1).getSkills()));

        for (int i = 0; i < studentJSONList.getStudentList().size(); i++) {
            System.out.println(studentJSONList.getStudentList().get(i).toString());
        }

        System.out.println("\n" + jane);
    }
}
