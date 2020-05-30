package mvclistdetailapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentDetailedUI extends JFrame {

    private JTextField firstNameDisplayValue;
    private JTextField lastNameDisplayValue;
    private JTextField universityDisplayValue;
    private JTextField gpaDisplayValue;

    private final int selectedRow;
    private final StudentCntrl studentCntrl;

    private JPanel studentPanel;
    private JPanel buttonsPanel;

    private Student currentStudent;

    public StudentDetailedUI(StudentCntrl studentCntrIn, int selectedRowIn) {
        studentCntrl = studentCntrIn;
        selectedRow = selectedRowIn;
        if (selectedRow != -1) {
            currentStudent = studentCntrl.getStudent(selectedRow);
            initComponents();
            parseCurrentStudent();
        } else {
            initComponents();
            parseNewStudent();
        }
    }

    private void initComponents() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstNameDisplayValue = new JTextField(15);
        lastNameDisplayValue = new JTextField(15);
        universityDisplayValue = new JTextField(15);
        gpaDisplayValue = new JTextField(15);

        studentPanel = new JPanel(new GridLayout(5, 1));

        studentPanel.add(new JLabel("First Name"));
        studentPanel.add(firstNameDisplayValue);
        studentPanel.add(new JLabel("Last Name"));
        studentPanel.add(lastNameDisplayValue);
        studentPanel.add(new JLabel("University"));
        studentPanel.add(universityDisplayValue);
        studentPanel.add(new JLabel("GPA"));
        studentPanel.add(gpaDisplayValue);

        buttonsPanel = new JPanel(new GridLayout(1, 4));
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener((ActionEvent e) -> {
            if (selectedRow != -1) {
                currentStudent.setFirstName(firstNameDisplayValue.getText());
                currentStudent.setLastName(lastNameDisplayValue.getText());
                currentStudent.setUniversity(universityDisplayValue.getText());
                currentStudent.setGpa(Double.parseDouble(gpaDisplayValue.getText()));
                StudentDetailedUI.this.studentCntrl.saveStudent(selectedRow, currentStudent);
                StudentDetailedUI.this.studentCntrl.getStudentListUI();
            } else {
                if (!firstNameDisplayValue.getText().equals("") || !lastNameDisplayValue.getText().equals("") || !universityDisplayValue.getText().equals("") || !gpaDisplayValue.getText().equals("")) {
                    StudentDetailedUI.this.studentCntrl.addStudent(firstNameDisplayValue.getText() + ", " + lastNameDisplayValue.getText() + ", " + universityDisplayValue.getText() + ", " + gpaDisplayValue.getText());
                    StudentDetailedUI.this.studentCntrl.getStudentListUI();
                } else {
                    JOptionPane.showMessageDialog(studentPanel, "You must enter a value for all fields!");
                }
            }
        });

        buttonsPanel.add(saveButton);
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener((ActionEvent e) -> {
            if (selectedRow != -1) {
                StudentDetailedUI.this.studentCntrl.removeStudent(selectedRow);
                StudentDetailedUI.this.studentCntrl.getStudentListUI();
            } else {
                JOptionPane.showMessageDialog(studentPanel, "Nothing to delete!");
            }
        });

        buttonsPanel.add(deleteButton);
        JButton doneButton = new JButton("Done");
        doneButton.addActionListener((ActionEvent e) -> {
            int value = JOptionPane.showConfirmDialog(studentPanel, "Are you sure you want to exit without saving?");
            if (value == 0) {
                StudentDetailedUI.this.studentCntrl.getStudentListUI();
            }
        });
        buttonsPanel.add(doneButton);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(studentPanel, BorderLayout.CENTER);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    }

    public JPanel getStudentPanel() {
        return studentPanel;
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    private void parseCurrentStudent() {
        firstNameDisplayValue.setText(currentStudent.getFirstName());
        lastNameDisplayValue.setText(currentStudent.getLastName());
        universityDisplayValue.setText(currentStudent.getUniversity());
        gpaDisplayValue.setText(Double.toString(currentStudent.getGpa()));
    }

    private void parseNewStudent() {
        firstNameDisplayValue.setText("");
        lastNameDisplayValue.setText("");
        universityDisplayValue.setText("");
        gpaDisplayValue.setText("");
    }
}
