package calendarapp.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class NorthPanel extends JPanel {

    private final SpringLayout layout;
    private final Dimension screenSize;

    private final JButton upMonth;
    private final JButton downMonth;
    private final JButton today;
    private final JButton monthButton;
    private final JButton yearButton;
    private final JLabel month;
    private final JLabel year;

    private final JLabel sunday;
    private final JLabel monday;
    private final JLabel tuesday;
    private final JLabel wednesday;
    private final JLabel thursday;
    private final JLabel friday;
    private final JLabel saturday;

    public NorthPanel(Dimension screenSize) throws IOException {
        this.screenSize = screenSize;
        layout = new SpringLayout();
        upMonth = new JButton();
        downMonth = new JButton();
        month = new JLabel();
        year = new JLabel();
        sunday = new JLabel("Sunday");
        monday = new JLabel("Monday");
        tuesday = new JLabel("Tuesday");
        wednesday = new JLabel("Wednesday");
        thursday = new JLabel("Thursday");
        friday = new JLabel("Friday");
        saturday = new JLabel("Saturday");
        today = new JButton("Today");
        monthButton = new JButton("Month");
        yearButton = new JButton("Year");
        InitComponents();
    }

    private void InitComponents() {
        setLayout(layout);

        upMonth.setIcon(new ImageIcon("Resources/Icons/up.png"));
        upMonth.setBorder(BorderFactory.createEmptyBorder());
        upMonth.setContentAreaFilled(false);
        upMonth.setPreferredSize(new Dimension(50, 50));
        upMonth.setFocusPainted(false);
        add(upMonth);

        downMonth.setIcon(new ImageIcon("Resources/Icons/down.png"));
        downMonth.setBorder(BorderFactory.createEmptyBorder());
        downMonth.setContentAreaFilled(false);
        downMonth.setPreferredSize(new Dimension(50, 50));
        downMonth.setFocusPainted(false);
        add(downMonth);

        month.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 40));
        month.setForeground(Color.decode("#FF9D00"));
        add(month);

        year.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 40));
        year.setForeground(Color.decode("#FF9D00"));
        add(year);

        sunday.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 100));
        add(sunday);

        monday.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 100));
        add(monday);

        tuesday.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 100));
        add(tuesday);

        wednesday.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 100));
        add(wednesday);

        thursday.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 100));
        add(thursday);

        friday.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 100));
        add(friday);

        saturday.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 100));
        add(saturday);

        today.setBackground(Color.decode("#FF9D00"));
        today.setPreferredSize(new Dimension(screenSize.width / 27, screenSize.height / 35));
        today.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 200));
        today.setFocusPainted(false);
        add(today);
        
        monthButton.setBackground(Color.decode("#FF9D00"));
        monthButton.setPreferredSize(new Dimension(screenSize.width / 27, screenSize.height / 35));
        monthButton.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 200));
        monthButton.setFocusPainted(false);
        add(monthButton);
        
        yearButton.setBackground(Color.decode("#FF9D00"));
        yearButton.setPreferredSize(new Dimension(screenSize.width / 27, screenSize.height / 35));
        yearButton.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 200));
        yearButton.setFocusPainted(false);
        add(yearButton);
    }

    @Override
    public SpringLayout getLayout() {
        return layout;
    }

    public JButton getDownMonth() {
        return downMonth;
    }

    public JLabel getMonth() {
        return month;
    }

    public JButton getUpMonth() {
        return upMonth;
    }

    public JLabel getYear() {
        return year;
    }

    public JButton getTodayButton() {
        return today;
    }

    public JButton getToday() {
        return today;
    }

    public JLabel getSunday() {
        return sunday;
    }

    public JLabel getMonday() {
        return monday;
    }

    public JLabel getTuesday() {
        return tuesday;
    }

    public JLabel getWednesday() {
        return wednesday;
    }

    public JLabel getThursday() {
        return thursday;
    }

    public JLabel getFriday() {
        return friday;
    }

    public JLabel getSaturday() {
        return saturday;
    }

    public JButton getMonthButton() {
        return monthButton;
    }

    public JButton getYearButton() {
        return yearButton;
    }
}
