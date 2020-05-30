package calendarapp.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class RightPanel extends JPanel {

    private final MonthCenterPanel centerPanel;
    private final NorthPanel northPanel;
    private final Dimension screenSize;

    public RightPanel(Dimension screenSizeIn) throws IOException {
        this.screenSize = screenSizeIn;
        northPanel = new NorthPanel(screenSize);
        centerPanel = new MonthCenterPanel();
        InitComponents();
    }

    private void InitComponents() {
        BorderLayout borderLayout = new BorderLayout(1, 1);
        setLayout(borderLayout);

        northPanel.setPreferredSize(new Dimension(0, screenSize.height / 11));
        northPanel.setBackground(Color.GRAY);
        add(northPanel, BorderLayout.NORTH);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getUpMonth(), 10, SpringLayout.WEST, northPanel);
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getUpMonth(), (screenSize.height / 11) / 4, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getDownMonth(), 0, SpringLayout.EAST, northPanel.getUpMonth());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getDownMonth(), (screenSize.height / 11) / 4, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getMonth(), (screenSize.height / 11) / 4, SpringLayout.EAST, northPanel.getDownMonth());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getMonth(), (screenSize.height / 11) / 4, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getYear(), 10, SpringLayout.EAST, northPanel.getMonth());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getYear(), (screenSize.height / 11) / 4, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getSunday(), (screenSize.width - (screenSize.width / 7)) / 19, SpringLayout.WEST, northPanel);
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getSunday(), (screenSize.height / 11) - northPanel.getSunday().getFont().getSize() - 5, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getMonday(), ((screenSize.width - (screenSize.width / 7)) / 10), SpringLayout.EAST, northPanel.getSunday());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getMonday(), (screenSize.height / 11) - northPanel.getMonday().getFont().getSize() - 5, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getTuesday(), ((screenSize.width - (screenSize.width / 7)) / 10), SpringLayout.EAST, northPanel.getMonday());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getTuesday(), (screenSize.height / 11) - northPanel.getTuesday().getFont().getSize() - 5, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getWednesday(), ((screenSize.width - (screenSize.width / 7)) / 10), SpringLayout.EAST, northPanel.getTuesday());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getWednesday(), (screenSize.height / 11) - northPanel.getWednesday().getFont().getSize() - 5, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getThursday(), ((screenSize.width - (screenSize.width / 7)) / 10), SpringLayout.EAST, northPanel.getWednesday());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getThursday(), (screenSize.height / 11) - northPanel.getThursday().getFont().getSize() - 5, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getFriday(), ((screenSize.width - (screenSize.width / 7)) / 10), SpringLayout.EAST, northPanel.getThursday());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getFriday(), (screenSize.height / 11) - northPanel.getFriday().getFont().getSize() - 5, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getSaturday(), ((screenSize.width - (screenSize.width / 7)) / 10), SpringLayout.EAST, northPanel.getFriday());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getSaturday(), (screenSize.height / 11) - northPanel.getSaturday().getFont().getSize() - 5, SpringLayout.NORTH, northPanel);

        northPanel.getLayout().putConstraint(SpringLayout.EAST, northPanel.getTodayButton(), (screenSize.width / 2), SpringLayout.WEST, northPanel);
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getTodayButton(), (screenSize.height / 11) / 3, SpringLayout.NORTH, northPanel);
        
        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getMonthButton(), 20, SpringLayout.EAST, northPanel.getTodayButton());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getMonthButton(), (screenSize.height / 11) / 3, SpringLayout.NORTH, northPanel);
        
        northPanel.getLayout().putConstraint(SpringLayout.WEST, northPanel.getYearButton(), 0, SpringLayout.EAST, northPanel.getMonthButton());
        northPanel.getLayout().putConstraint(SpringLayout.NORTH, northPanel.getYearButton(), (screenSize.height / 11) / 3, SpringLayout.NORTH, northPanel);

        add(centerPanel, BorderLayout.CENTER);

    }

    public MonthCenterPanel getCenterPanel() {
        return centerPanel;
    }

    public NorthPanel getNorthPanel() {
        return northPanel;
    }
}
