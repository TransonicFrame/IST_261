package mvcapp;

public class Student {

    private final String firstName;
    private final String lastName;
    private final String university;
    private final Double gpa;

    public Student(String firstName, String lastName, String university, Double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
        this.gpa = gpa;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUniversity() {
        return university;
    }

    public Double getGpa() {
        return gpa;
    }
}
