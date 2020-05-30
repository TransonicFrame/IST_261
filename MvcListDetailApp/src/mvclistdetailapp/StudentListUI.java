package mvclistdetailapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;

public class StudentListUI extends JFrame implements Scrollable {

    StudentCntrl studentCntrl;
    StudentDetailedUI studentDetailedUI;

    private JTable studentTable;
    private JScrollPane tableScroller;

    private JPanel tablePanel;
    private JPanel buttonPanel;

    private JButton doneButton;
    private JButton newButton;
    private JButton detailsButton;

    public StudentListUI(StudentCntrl studentCntrl) {
        this.studentCntrl = studentCntrl;
        initComponents();
    }

    private void initComponents() {
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 4));
        studentTable = new JTable(studentCntrl.getStudentTableModel());
        studentTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        studentTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        doneButton = new JButton("Done");
        doneButton.addActionListener((ActionEvent e) -> {
            Runtime.getRuntime().exit(0);
        });
        detailsButton = new JButton("Show Details");
        detailsButton.addActionListener(new DetailsButtonListener());
        newButton = new JButton("New");
        newButton.addActionListener(new NewButtonListener());
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);
        tableScroller = new JScrollPane(studentTable);
        studentTable.setFillsViewportHeight(true);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(450, 300));
        tablePanel.add(tableScroller);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public class NewButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentListUI.this.studentCntrl.getStudentDetailUI(-1);
        }
    }

    public class DetailsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedTableRow = studentTable.getSelectedRow();
            int selectedModelRow = studentTable.convertRowIndexToModel(selectedTableRow);
            if (selectedModelRow >= 0) {
                if (studentTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(studentTable, "No students! You must add a new student!");
                } else {
                    StudentListUI.this.studentCntrl.getStudentDetailUI(selectedModelRow);
                }
            } else {
                JOptionPane.showMessageDialog(studentTable, "You must select a student!");
            }
            studentTable.clearSelection();
        }
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(tableScroller.getViewport().getWidth(), tableScroller.getViewport().getHeight());
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
