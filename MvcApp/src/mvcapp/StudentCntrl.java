package mvcapp;

import java.io.FileNotFoundException;

public class StudentCntrl {

    private static final int STARTING_INDEX_OF_DISPLAY = 0;
    private final StudentList studentList;
    private final StudentUI studentUI;

    public StudentCntrl() throws FileNotFoundException {
        studentList = new StudentList();
        studentUI = new StudentUI(STARTING_INDEX_OF_DISPLAY, studentList.getStudentList());
        studentUI.previousStudentActionListener(studentList.getStudentList());
        studentUI.newStudentActionListener(studentList.getStudentList());
        studentUI.saveStudentActionListener(studentList.getStudentList());
        studentUI.deleteStudentActionListener(studentList.getStudentList());
        studentUI.nextStudentListener(studentList.getStudentList());
        studentUI.setVisible(true);
    }
}
