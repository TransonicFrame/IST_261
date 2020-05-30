package calendarapp.View;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class NewEvent extends JFrame {

    private final NewEventInitialPanel newEventInitialPanel;
    private final Dimension screenSize;

    public NewEvent(Dimension screenSize) throws ParseException {
        super("New Event");
        this.screenSize = screenSize;
        newEventInitialPanel = new NewEventInitialPanel(screenSize);
        InitComponents();
    }

    private void InitComponents() {
        newEventInitialPanel.setBackground(Color.gray);
        add(newEventInitialPanel);

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getSave(), 10, SpringLayout.WEST, newEventInitialPanel);
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getDelete(), 0, SpringLayout.EAST, newEventInitialPanel.getSave());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getStartDateLabel(), 0, SpringLayout.WEST, newEventInitialPanel);
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getStartDateLabel(), screenSize.width / 20, SpringLayout.NORTH, newEventInitialPanel);

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getEventName(), 0, SpringLayout.EAST, newEventInitialPanel.getStartDateLabel());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getEventName(), 10, SpringLayout.SOUTH, newEventInitialPanel.getSave());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getStartDate(), 0, SpringLayout.EAST, newEventInitialPanel.getStartDateLabel());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getStartDate(), 0, SpringLayout.SOUTH, newEventInitialPanel.getEventName());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getStartTimeLabel(), 0, SpringLayout.EAST, newEventInitialPanel.getStartDate());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getStartTimeLabel(), screenSize.width / 20, SpringLayout.NORTH, newEventInitialPanel);

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getStartTime(), 0, SpringLayout.EAST, newEventInitialPanel.getStartTimeLabel());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getStartTime(), 0, SpringLayout.SOUTH, newEventInitialPanel.getEventName());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getEndDateLabel(), 0, SpringLayout.WEST, newEventInitialPanel);
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getEndDateLabel(), 0, SpringLayout.SOUTH, newEventInitialPanel.getStartDateLabel());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getEndDate(), 0, SpringLayout.EAST, newEventInitialPanel.getEndDateLabel());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getEndDate(), 0, SpringLayout.SOUTH, newEventInitialPanel.getStartDate());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getEndTimeLabel(), 0, SpringLayout.EAST, newEventInitialPanel.getEndDate());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getEndTimeLabel(), 0, SpringLayout.SOUTH, newEventInitialPanel.getStartTimeLabel());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getEndTime(), 0, SpringLayout.WEST, newEventInitialPanel.getStartTime());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getEndTime(), 0, SpringLayout.SOUTH, newEventInitialPanel.getStartTime());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getLocationBox(), 0, SpringLayout.EAST, newEventInitialPanel.getStartDateLabel());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getLocationBox(), 0, SpringLayout.SOUTH, newEventInitialPanel.getEndDate());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getAllDay(), 100, SpringLayout.EAST, newEventInitialPanel.getLocationBox());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getAllDay(), 0, SpringLayout.NORTH, newEventInitialPanel.getLocationBox());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getAmStart(), 0, SpringLayout.EAST, newEventInitialPanel.getStartTime());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getAmStart(), 0, SpringLayout.NORTH, newEventInitialPanel.getStartTime());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getPmStart(), 0, SpringLayout.EAST, newEventInitialPanel.getAmStart());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getPmStart(), 0, SpringLayout.NORTH, newEventInitialPanel.getStartTime());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getAmEnd(), 0, SpringLayout.EAST, newEventInitialPanel.getEndTime());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getAmEnd(), 0, SpringLayout.NORTH, newEventInitialPanel.getEndTime());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getPmEnd(), 0, SpringLayout.EAST, newEventInitialPanel.getAmEnd());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getPmEnd(), 0, SpringLayout.NORTH, newEventInitialPanel.getEndTime());

        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.NORTH, newEventInitialPanel.getDescription(), 50, SpringLayout.SOUTH, newEventInitialPanel.getLocationBox());
        newEventInitialPanel.getSpringLayout().putConstraint(SpringLayout.WEST, newEventInitialPanel.getDescription(), 12, SpringLayout.WEST, newEventInitialPanel);
    }

    public NewEventInitialPanel getNewEventInitialPanel() {
        return newEventInitialPanel;
    }
}
