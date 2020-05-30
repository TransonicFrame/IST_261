package studentinfogsonapp;

public class Student {

    private final String firstName;
    private final String lastName;
    private final double gpa;
    private final PhoneNumber phoneNumber;
    private final String[] skills;

    public Student(String firstName, String lastName, double gpa, PhoneNumber phoneNumber, String[] skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
    }

    private String skillsToString(String[] skills) {
        StringBuilder skillsString = new StringBuilder();
        skillsString.append("[");
        int counter = 0;
        for (String studentSkills : skills) {
            skillsString.append(studentSkills);
            counter++;
            if (counter != skills.length) {
                skillsString.append(",");
            }
        }
        skillsString.append("]");
        return skillsString.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String[] getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "[" + "firstName: " + firstName + ", lastName: " + lastName + ", gpa: " + gpa + ", phoneNumber=" + phoneNumber + ", skills: " + skillsToString(skills) + ']';
    }
}
