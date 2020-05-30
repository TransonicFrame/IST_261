package mvclistdetailapp;

public class Student {

    private String firstName;
    private String lastName;
    private String university;
    private Double gpa;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}
