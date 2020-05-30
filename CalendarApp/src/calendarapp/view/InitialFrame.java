package calendarapp.View;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class InitialFrame extends JFrame {

    private final InitialPanel initialPanel;

    public InitialFrame(ArrayList<String> eventArrayList, Dimension screenSize) throws IOException {
        super("CalendarApp");
        initialPanel = new InitialPanel(screenSize);
        InitComponents();
    }

    private void InitComponents() {
        add(initialPanel, "Center");
    }

    public InitialPanel getInitialPanel() {
        return initialPanel;
    }
}
