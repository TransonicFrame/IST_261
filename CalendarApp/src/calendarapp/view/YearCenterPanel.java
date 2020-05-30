package calendarapp.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

public class YearCenterPanel extends JPanel {

    private MonthPanel monthPanel;
    private final ArrayList<MonthPanel> monthPanelArray;
    private final SpringLayout layout;
    private final HashMap<Integer, ArrayList<Integer>> dateHashMap;

    public YearCenterPanel(HashMap<Integer, ArrayList<Integer>> dateHashMap) {
        monthPanelArray = new ArrayList<>();
        layout = new SpringLayout();
        this.dateHashMap = dateHashMap;
        InitComponents();
    }

    private void InitComponents() {
        setBackground(Color.gray);
        setLayout(new GridLayout(2, 6));
        for (int i = 0; i < 12; i++) {
            String panelName = ("monthPanel" + i);
            monthPanelArray.add(new MonthPanel(panelName, layout));
            monthPanel = monthPanelArray.get(i);
            monthPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
            monthPanel.setBackground(Color.lightGray);
            add(monthPanel);
            validate();
        }
        monthPanelArray.get(0).getMonth().setText("January");
        monthPanelArray.get(1).getMonth().setText("February");
        monthPanelArray.get(2).getMonth().setText("March");
        monthPanelArray.get(3).getMonth().setText("April");
        monthPanelArray.get(4).getMonth().setText("May");
        monthPanelArray.get(5).getMonth().setText("June");
        monthPanelArray.get(6).getMonth().setText("July");
        monthPanelArray.get(7).getMonth().setText("August");
        monthPanelArray.get(8).getMonth().setText("September");
        monthPanelArray.get(9).getMonth().setText("October");
        monthPanelArray.get(10).getMonth().setText("November");
        monthPanelArray.get(11).getMonth().setText("December");

        for (int i = 0; i < monthPanelArray.size(); i++) {
            int dayCounter = 1;
            for (int j = dateHashMap.get(i).get(0) - 1; j < monthPanelArray.get(i).getDayPanelArray().size(); j++) {
                monthPanelArray.get(i).getDayPanelArray().get(j).getNumber().setText(Integer.toString(dayCounter));
                dayCounter++;
                if (dayCounter - 1 == dateHashMap.get(i).get(1)){
                    break;
                }
            }
        }
    }
}
