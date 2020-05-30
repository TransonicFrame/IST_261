package studentinfoapp;

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

    @Override
    public String toString() {
        return "[firstName: " + getFirstName() + ", lastName: " + getLastName() + ", gpa: " + getGpa() + ", " + getPhoneNumber().toString() + ", skills: " + skillsToString(getSkills()) + "]";
    }

    //skillsToString method needed to format the skills in the a way which correspomds to the assignment (Without = [people skills, Java, Javascript, Python]; With = [people skills,Java,Javascript,Python])
    private String skillsToString(String[] skills) {
        StringBuilder skillsString = new StringBuilder();
        int counter = 0;
        skillsString.append("[");
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

    public String[] getSkills() {
        return skills;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
