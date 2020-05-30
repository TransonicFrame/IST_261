package calendarapp.View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

public class MonthCenterPanel extends JPanel {

    private DayPanel dayPanel;
    private final ArrayList<DayPanel> dayPanelArray;
    private final SpringLayout layout;

    public MonthCenterPanel() {
        dayPanelArray = new ArrayList<>();
        layout = new SpringLayout();
        InitComponents();
    }

    private void InitComponents() {
        setBackground(Color.gray);
        setLayout(new GridLayout(5, 1));
        for (int i = 0; i < (5 * 7); i++) {
            String panelName = ("dayPanel" + i);
            dayPanelArray.add(new DayPanel(panelName, layout));
            dayPanel = dayPanelArray.get(i);
            dayPanel.setBorder(new LineBorder(Color.black));
            dayPanel.setBackground(Color.lightGray);
            dayPanel.getNumber().setText("");
            add(dayPanel);
            validate();
        }
    }

    public ArrayList<DayPanel> getDayPanelArray() {
        return dayPanelArray;
    }

    public DayPanel getDayPanel() {
        return dayPanel;
    }
}
