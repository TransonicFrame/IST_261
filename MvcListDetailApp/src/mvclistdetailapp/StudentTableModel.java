package mvclistdetailapp;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {

    private final String[] columnName = {"First Name", "Last Name", "University", "GPA"};
    private final ArrayList<Student> studentList;

    public StudentTableModel(ArrayList<Student> newStudentList) {
        studentList = newStudentList;
    }

    public String getColumnName(int col) {
        return columnName[col];
    }

    public int getRowCount() {
        return studentList.size();
    }

    public int getColumnCount() {
        return columnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) studentList.get(rowIndex).getFirstName();
            case 1:
                return (Object) studentList.get(rowIndex).getLastName();
            case 2:
                return (Object) studentList.get(rowIndex).getUniversity();
            case 3:
                return (Object) studentList.get(rowIndex).getGpa();
            default:
                return null;
        }
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }
}
