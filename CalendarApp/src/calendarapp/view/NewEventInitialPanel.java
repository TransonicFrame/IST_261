package calendarapp.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

public class NewEventInitialPanel extends JPanel {

    private final SpringLayout springLayout;
    private final Dimension screenSize;

    private final JButton save;
    private final JButton delete;
    private final JTextField eventName;
    private final JFormattedTextField startDate;
    private final JLabel startDateLabel;
    private final JFormattedTextField startTime;
    private final JLabel startTimeLabel;
    private final JFormattedTextField endDate;
    private final JLabel endDateLabel;
    private final JFormattedTextField endTime;
    private final JLabel endTimeLabel;
    private final JTextField locationBox;
    private final JCheckBox allDay;
    private final JCheckBox amStart;
    private final JCheckBox pmStart;
    private final JCheckBox amEnd;
    private final JCheckBox pmEnd;
    private final JTextArea description;

    private final MaskFormatter dateFormatter;
    private final MaskFormatter timeFormatter;

    public NewEventInitialPanel(Dimension screenSize) throws ParseException {
        this.screenSize = screenSize;
        dateFormatter = new MaskFormatter("##/##/####");
        dateFormatter.setPlaceholderCharacter('_');
        timeFormatter = new MaskFormatter("##:##:##");
        timeFormatter.setPlaceholderCharacter('_');
        springLayout = new SpringLayout();
        save = new JButton("Save");
        delete = new JButton("Delete");
        eventName = new JTextField("Event Name");
        startDateLabel = new JLabel("<html><div style='text-align: center;'><br>Start Date:<br>mm/dd/yyyy</html>");
        startDate = new JFormattedTextField(dateFormatter);
        startTimeLabel = new JLabel("<html><div style='text-align: center;'><br>Start Time:<br>hr:min:sec</html>");
        startTime = new JFormattedTextField(timeFormatter);
        endDateLabel = new JLabel("<html><div style='text-align: center;'><br>End Date:<br>mm/dd/yyyy</html>");
        endDate = new JFormattedTextField(dateFormatter);
        endTimeLabel = new JLabel("<html><div style='text-align: center;'><br>End Time:<br>hr:min:sec</html>");
        endTime = new JFormattedTextField(timeFormatter);
        locationBox = new JTextField("Location");
        allDay = new JCheckBox("All day");
        amStart = new JCheckBox("AM");
        pmStart = new JCheckBox("PM");
        amEnd = new JCheckBox("AM");
        pmEnd = new JCheckBox("PM");
        description = new JTextArea("Desrciption");

        InitComponents();
    }

    private void InitComponents() {
        setLayout(springLayout);

        save.setBackground(Color.decode("#FF9D00"));
        save.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        save.setPreferredSize(new Dimension(screenSize.height / 15, screenSize.width / 50));
        add(save);

        delete.setBackground(Color.decode("#FF9D00"));
        delete.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        delete.setPreferredSize(new Dimension(screenSize.height / 15, screenSize.width / 50));
        add(delete);

        eventName.setPreferredSize(new Dimension(screenSize.height / 7, screenSize.width / 40));
        eventName.setBackground(Color.lightGray);
        eventName.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        eventName.setBorder(new LineBorder(Color.gray));
        add(eventName);

        eventName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (eventName.getText().equals("Event Name")) {
                    eventName.setText("");

                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (eventName.getText().equals("")) {
                    eventName.setText("Event Name");
                }
            }
        });

        startDateLabel.setPreferredSize(new Dimension(screenSize.height / 17, screenSize.width / 40));
        startDateLabel.setBackground(Color.lightGray);
        startDateLabel.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        startDateLabel.setBorder(new LineBorder(Color.gray));
        add(startDateLabel);

        startDate.setPreferredSize(new Dimension(screenSize.height / 7, screenSize.width / 40));
        startDate.setBackground(Color.lightGray);
        startDate.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        startDate.setBorder(new LineBorder(Color.gray));
        add(startDate);

        startTimeLabel.setPreferredSize(new Dimension(screenSize.height / 15, screenSize.width / 40));
        startTimeLabel.setBackground(Color.lightGray);
        startTimeLabel.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        startTimeLabel.setBorder(new LineBorder(Color.gray));
        add(startTimeLabel);

        startTime.setPreferredSize(new Dimension(screenSize.height / 15, screenSize.width / 40));
        startTime.setBackground(Color.lightGray);
        startTime.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        startTime.setBorder(new LineBorder(Color.gray));
        add(startTime);

        endDateLabel.setPreferredSize(new Dimension(screenSize.height / 17, screenSize.width / 40));
        endDateLabel.setBackground(Color.lightGray);
        endDateLabel.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        endDateLabel.setBorder(new LineBorder(Color.gray));
        add(endDateLabel);

        endDate.setPreferredSize(new Dimension(screenSize.height / 7, screenSize.width / 40));
        endDate.setBackground(Color.lightGray);
        endDate.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        endDate.setBorder(new LineBorder(Color.gray));
        add(endDate);

        endTimeLabel.setPreferredSize(new Dimension(screenSize.height / 17, screenSize.width / 40));
        endTimeLabel.setBackground(Color.lightGray);
        endTimeLabel.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        endTimeLabel.setBorder(new LineBorder(Color.gray));
        add(endTimeLabel);

        endTime.setPreferredSize(new Dimension(screenSize.height / 15, screenSize.width / 40));
        endTime.setBackground(Color.lightGray);
        endTime.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        endTime.setBorder(new LineBorder(Color.gray));
        add(endTime);

        locationBox.setPreferredSize(new Dimension(screenSize.height / 7, screenSize.width / 40));
        locationBox.setBackground(Color.lightGray);
        locationBox.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        locationBox.setBorder(new LineBorder(Color.gray));
        add(locationBox);

        locationBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (locationBox.getText().equals("Location")) {
                    locationBox.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (locationBox.getText().equals("")) {
                    locationBox.setText("Location");
                }
            }
        });

        allDay.setPreferredSize(new Dimension(screenSize.height / 7, screenSize.width / 40));
        allDay.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        allDay.setBackground(Color.gray);
        add(allDay);

        amStart.setPreferredSize(new Dimension(screenSize.height / 20, screenSize.width / 40));
        amStart.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        amStart.setBackground(Color.gray);
        add(amStart);

        pmStart.setPreferredSize(new Dimension(screenSize.height / 20, screenSize.width / 40));
        pmStart.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        pmStart.setBackground(Color.gray);
        add(pmStart);

        amEnd.setPreferredSize(new Dimension(screenSize.height / 20, screenSize.width / 40));
        amEnd.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        amEnd.setBackground(Color.gray);
        add(amEnd);

        pmEnd.setPreferredSize(new Dimension(screenSize.height / 20, screenSize.width / 40));
        pmEnd.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 150));
        pmEnd.setBackground(Color.gray);
        add(pmEnd);

        description.setPreferredSize(new Dimension((screenSize.height / 2) - 50, (screenSize.width / 3) - 50));
        description.setBackground(Color.lightGray);
        description.setLineWrap(true);
        description.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 75));
        add(description);

        description.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (description.getText().equals("Desrciption")) {
                    description.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (description.getText().equals("")) {
                    description.setText("Desrciption");
                }
            }
        });
    }

    public SpringLayout getSpringLayout() {
        return springLayout;
    }

    public JButton getSave() {
        return save;
    }

    public JButton getDelete() {
        return delete;
    }

    public JTextField getEventName() {
        return eventName;
    }

    public JFormattedTextField getStartDate() {
        return startDate;
    }

    public JFormattedTextField getStartTime() {
        return startTime;
    }

    public JFormattedTextField getEndDate() {
        return endDate;
    }

    public JFormattedTextField getEndTime() {
        return endTime;
    }

    public JTextField getLocationBox() {
        return locationBox;
    }

    public JCheckBox getAllDay() {
        return allDay;
    }

    public JTextArea getDescription() {
        return description;
    }

    public JLabel getStartDateLabel() {
        return startDateLabel;
    }

    public JLabel getStartTimeLabel() {
        return startTimeLabel;
    }

    public JLabel getEndDateLabel() {
        return endDateLabel;
    }

    public JLabel getEndTimeLabel() {
        return endTimeLabel;
    }

    public JCheckBox getAmStart() {
        return amStart;
    }

    public JCheckBox getPmStart() {
        return pmStart;
    }

    public JCheckBox getAmEnd() {
        return amEnd;
    }

    public JCheckBox getPmEnd() {
        return pmEnd;
    }
}
