package calendarapp.view;

import calendarapp.View.DayPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

public class MonthPanel extends JPanel{
    
    private calendarapp.View.DayPanel dayPanel;
    private final ArrayList<calendarapp.View.DayPanel> dayPanelArray;
    private final JLabel month;
    private final JLabel sun;
    private final JLabel mon;
    private final JLabel tues;
    private final JLabel wed;
    private final JLabel thurs;
    private final JLabel fri;
    private final JLabel sat;
    private final JPanel northPanel;
    private final JPanel centerPanel;
    private final SpringLayout layout;
    
    public MonthPanel(String panelName, SpringLayout layout){
        this.layout = layout;
        month = new JLabel(panelName);
        sun = new JLabel("Su");
        mon = new JLabel("Mo");
        tues = new JLabel("Tu");
        wed = new JLabel("We");
        thurs = new JLabel("Th");
        fri = new JLabel("Fr");
        sat = new JLabel("Sa");
        northPanel = new JPanel();
        centerPanel = new JPanel();
        dayPanelArray = new ArrayList<>();
        InitComponents();
    }
    
    private void InitComponents(){
        BorderLayout borderLayout = new BorderLayout(1, 1);
        setLayout(borderLayout);
        setBackground(Color.lightGray);
        
        northPanel.setPreferredSize(new Dimension(100, 50));
        northPanel.setBackground(Color.lightGray);
        northPanel.setLayout(layout);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        month.setForeground(Color.BLACK);
        month.setFont(new Font("Times New Roman", Font.BOLD, 25));
        northPanel.add(month);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, month, 0, SpringLayout.HORIZONTAL_CENTER, northPanel);
        
        
        sun.setForeground(Color.BLACK);
        sun.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(sun);
        layout.putConstraint(SpringLayout.WEST, sun, 20, SpringLayout.WEST, northPanel);
        layout.putConstraint(SpringLayout.SOUTH, sun, 5, SpringLayout.SOUTH, northPanel);
        
        mon.setForeground(Color.BLACK);
        mon.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(mon);
        layout.putConstraint(SpringLayout.WEST, mon, 40, SpringLayout.EAST, sun);
        layout.putConstraint(SpringLayout.SOUTH, mon, 5, SpringLayout.SOUTH, northPanel);
        
        tues.setForeground(Color.BLACK);
        tues.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(tues);
        layout.putConstraint(SpringLayout.WEST, tues, 35, SpringLayout.EAST, mon);
        layout.putConstraint(SpringLayout.SOUTH, tues, 5, SpringLayout.SOUTH, northPanel);
        
        wed.setForeground(Color.BLACK);
        wed.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(wed);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, wed, 0, SpringLayout.HORIZONTAL_CENTER, northPanel);
        layout.putConstraint(SpringLayout.SOUTH, wed, 5, SpringLayout.SOUTH, northPanel);
        
        thurs.setForeground(Color.BLACK);
        thurs.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(thurs);
        layout.putConstraint(SpringLayout.WEST, thurs, 35, SpringLayout.EAST, wed);
        layout.putConstraint(SpringLayout.SOUTH, thurs, 5, SpringLayout.SOUTH, northPanel);
        
        fri.setForeground(Color.BLACK);
        fri.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(fri);
        layout.putConstraint(SpringLayout.WEST, fri, 40, SpringLayout.EAST, thurs);
        layout.putConstraint(SpringLayout.SOUTH, fri, 5, SpringLayout.SOUTH, northPanel);
        
        sat.setForeground(Color.BLACK);
        sat.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(sat);
        layout.putConstraint(SpringLayout.WEST, sat, 40, SpringLayout.EAST, fri);
        layout.putConstraint(SpringLayout.SOUTH, sat, 5, SpringLayout.SOUTH, northPanel);
        
        centerPanel.setLayout(new GridLayout(6, 7));
        for (int i = 0; i < (6 * 7); i++) {
            String panelName = ("dayPanel" + i);
            dayPanelArray.add(new DayPanel(panelName, layout));
            dayPanel = dayPanelArray.get(i);
            dayPanel.setBorder(new LineBorder(Color.black));
            dayPanel.setBackground(Color.lightGray);
            dayPanel.getNumber().setText("");
            centerPanel.add(dayPanel);
            validate();
        }
    }

    public JLabel getMonth() {
        return month;
    }

    public ArrayList<DayPanel> getDayPanelArray() {
        return dayPanelArray;
    }
    
    
}
