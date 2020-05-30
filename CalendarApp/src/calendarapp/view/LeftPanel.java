package calendarapp.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftPanel extends JPanel {

    private final JButton newEvent;
    private final Dimension screenSize;

    public LeftPanel(Dimension screenSize) {
        this.screenSize = screenSize;
        newEvent = new JButton();
        InitComponents();
    }

    private void InitComponents() {
        BorderLayout borderLayout = new BorderLayout(1, 1);
        setLayout(borderLayout);
        newEvent.setText("+ New Event");
        newEvent.setBackground(Color.gray);
        newEvent.setForeground(Color.decode("#FF9D00"));
        newEvent.setFont(new Font("Times New Roman", Font.BOLD, screenSize.width / 50));
        newEvent.setFocusPainted(false);
        newEvent.setBorderPainted(false);
        newEvent.setPreferredSize(new Dimension(0, screenSize.height / 11));
        add(newEvent, BorderLayout.NORTH);
    }

    public JButton getNewEvent() {
        return newEvent;
    }
}
