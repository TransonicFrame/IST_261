package calendarapp.View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class DayPanel extends JPanel {

    private final JLabel number;
    private final SpringLayout layout;

    public DayPanel(String panelName, SpringLayout layout) {
        this.layout = layout;
        number = new JLabel(panelName);
        InitComponents();
    }

    private void InitComponents() {
        setLayout(layout);
        number.setForeground(Color.BLACK);
        number.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(number);
        layout.putConstraint(SpringLayout.WEST, number, 2, SpringLayout.WEST, this);
    }

    public JLabel getNumber() {
        return number;
    }

    @Override
    public SpringLayout getLayout() {
        return layout;
    }
}
