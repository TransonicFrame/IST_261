package calendarapp.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JPanel;

public class InitialPanel extends JPanel {

    private final RightPanel rightPanel;
    private final LeftPanel leftPanel;
    private final Dimension screenSize;

    public InitialPanel(Dimension screensize) throws IOException {
        this.screenSize = screensize;
        rightPanel = new RightPanel(screensize);
        leftPanel = new LeftPanel(screensize);
        InitComponents();
    }

    private void InitComponents() {
        setLayout(new BorderLayout(1, 1));
        add(rightPanel, BorderLayout.CENTER);
        leftPanel.setBackground(Color.gray);
        leftPanel.setPreferredSize(new Dimension(screenSize.width / 7, 0));
        add(leftPanel, BorderLayout.WEST);
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }
}
