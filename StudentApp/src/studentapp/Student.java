package studentapp;

public class Student {

    private final String lastname;
    private final String firstname;
    private final double gpa;

    public Student(String lastname, String firstname, double gpa) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return '[' + "lastName = " + getLastname() + "; firstName = " + getFirstname() + "; gpa = " + getGpa() + ']';
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public double getGpa() {
        return gpa;
    }

}
