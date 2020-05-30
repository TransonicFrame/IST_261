package mvcapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentUI extends JFrame {

    private int indexOfitemToDispaly;

    private JTextField firstNameDisplayValue;
    private JTextField lastNameDisplayValue;
    private JTextField universityDisplayValue;
    private JTextField gpaDisplayValue;

    private JPanel studentPanel;
    private JPanel buttonsPanel;

    ArrayList<Student> initalStudentArrayList = new ArrayList<>();

    public StudentUI(int startingIndexOfDisplay, ArrayList<Student> initalStudentArrayList) {
        indexOfitemToDispaly = startingIndexOfDisplay;
        this.initalStudentArrayList = initalStudentArrayList;
        initComponents();
        setFieldView();
    }

    private void initComponents() {
        setTitle("Student Information");
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

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(studentPanel, BorderLayout.CENTER);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    }

    //Public in order to recieve information from controller
    public void nextStudentListener(ArrayList<Student> studentArrayList) {
        JButton nextButton = new JButton("Next");
        buttonsPanel.add(nextButton);
        nextButton.addActionListener((ActionEvent e) -> {
            if (!studentArrayList.isEmpty()) {
                if (indexOfitemToDispaly != studentArrayList.size() - 1) {
                    indexOfitemToDispaly = indexOfitemToDispaly + 1;
                } else {
                    indexOfitemToDispaly = indexOfitemToDispaly - indexOfitemToDispaly;
                }
                setFieldView();
            } else if (studentArrayList.isEmpty()) {
                JOptionPane.showMessageDialog(studentPanel, "No students exist, add new!");
            }
        });
    }

    //Public in order to recieve information from controller
    public void newStudentActionListener(ArrayList<Student> studentArrayList) {
        JButton newButton = new JButton("New");
        buttonsPanel.add(newButton);
        newButton.addActionListener((ActionEvent e) -> {
            if (!studentArrayList.isEmpty()) {
                if (firstNameDisplayValue.getText().equalsIgnoreCase(studentArrayList.get(indexOfitemToDispaly).getFirstName()) || lastNameDisplayValue.getText().equalsIgnoreCase(studentArrayList.get(indexOfitemToDispaly).getLastName())) {
                    JOptionPane.showMessageDialog(studentPanel, "You must edit all of these values first!");
                }
            }

            studentArrayList.add(new Student(firstNameDisplayValue.getText(), lastNameDisplayValue.getText(), universityDisplayValue.getText(), Double.parseDouble(gpaDisplayValue.getText())));
        });
    }

    //Public in order to recieve information from controller
    public void saveStudentActionListener(ArrayList<Student> studentArrayList) {
        JButton saveButton = new JButton("Save");
        buttonsPanel.add(saveButton);
        saveButton.addActionListener((ActionEvent e) -> {
            studentArrayList.set(indexOfitemToDispaly, new Student(firstNameDisplayValue.getText(), lastNameDisplayValue.getText(), universityDisplayValue.getText(), Double.parseDouble(gpaDisplayValue.getText())));
        });
    }

    //Public in order to recieve information from controller
    public void deleteStudentActionListener(ArrayList<Student> studentArrayList) {
        JButton deleteButton = new JButton("Delete");
        buttonsPanel.add(deleteButton);
        deleteButton.addActionListener((ActionEvent e) -> {
            if (studentArrayList.size() > 0) {
                studentArrayList.remove(indexOfitemToDispaly);
                firstNameDisplayValue.setText("");
                lastNameDisplayValue.setText("");
                universityDisplayValue.setText("");
                gpaDisplayValue.setText("");
                indexOfitemToDispaly = 0;
            }
        });
    }

    //Public in order to recieve information from controller
    public void previousStudentActionListener(ArrayList<Student> studentArrayList) {
        JButton backButton = new JButton("Back");
        buttonsPanel.add(backButton);
        backButton.addActionListener((ActionEvent e) -> {
            if (!studentArrayList.isEmpty()) {
                if (indexOfitemToDispaly != studentArrayList.size() - initalStudentArrayList.size()) {
                    indexOfitemToDispaly = indexOfitemToDispaly - 1;
                } else {
                    indexOfitemToDispaly = indexOfitemToDispaly + initalStudentArrayList.size() - 1;
                }
                setFieldView();
            } else if (studentArrayList.isEmpty()) {
                JOptionPane.showMessageDialog(studentPanel, "No students exist, add new!");
            }
        });
    }

    private void setFieldView() {
        firstNameDisplayValue.setText(initalStudentArrayList.get(indexOfitemToDispaly).getFirstName());
        lastNameDisplayValue.setText(initalStudentArrayList.get(indexOfitemToDispaly).getLastName());
        universityDisplayValue.setText(initalStudentArrayList.get(indexOfitemToDispaly).getUniversity());
        gpaDisplayValue.setText(initalStudentArrayList.get(indexOfitemToDispaly).getGpa().toString());
    }
}
