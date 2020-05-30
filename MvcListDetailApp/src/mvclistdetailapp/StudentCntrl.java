package mvclistdetailapp;

public class StudentCntrl {

    private final StudentList studentList;
    private final StudentTableModel studentTableModel;
    private final StudentListUI studentListUI;
    private StudentDetailedUI studentDetailedUI;

    public StudentCntrl() {
        studentList = new StudentList();
        studentTableModel = new StudentTableModel(studentList.getStudentList());
        studentListUI = new StudentListUI(this);
        studentListUI.setVisible(true);
    }

    public StudentTableModel getStudentTableModel() {
        return studentTableModel;
    }

    public void getStudentDetailUI(int selectedRow) {
        studentDetailedUI = new StudentDetailedUI(this, selectedRow);
        studentListUI.setVisible(false);
        studentDetailedUI.setVisible(true);
    }

    public void addStudent(String student) {
        String[] studentSplit = student.split(", ");
        studentList.getStudentList().add(new Student(studentSplit[0], studentSplit[1], studentSplit[2], Double.parseDouble(studentSplit[3])));
    }

    public void saveStudent(int selectedRow, Student studentChanged) {
        studentList.getStudentList().set(selectedRow, studentChanged);
    }

    public void removeStudent(int selectedRow) {
        studentList.getStudentList().remove(selectedRow);
    }

    public void getStudentListUI() {
        studentDetailedUI.setVisible(false);
        studentListUI.setVisible(true);
    }

    public Student getStudent(int selectedRow) {
        return studentList.getStudentList().get(selectedRow);
    }
}
