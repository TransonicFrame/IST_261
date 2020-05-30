package investmentviewerfixme;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Code from Big Java Late Objects, 1st edition by Cay Horstmann
 * A frame that shows the growth of an investment with variable interest, using
 * a text area.
 */
public class InvestmentFrame3 extends JFrame {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 250;

    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;

    private static final double DEFAULT_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private final JTextArea resultArea;
    private double balance;

    public InvestmentFrame3() {
        balance = INITIAL_BALANCE;
        resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        resultArea.setText(balance + "\n");
        resultArea.setEditable(false);

        createTextField();
        createButton();
        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField() {
        rateLabel = new JLabel("Interest Rate: ");
        final int FIELD_WIDTH = 10;
        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText("" + DEFAULT_RATE);
    }

    private void createButton() {
        button = new JButton("Add Interest");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] resultArray = resultArea.getText().split("\\s+");
                double lastAmount = Double.parseDouble(resultArray[resultArray.length - 1]);
                double interest = Double.parseDouble(rateField.getText()) / 100;
                resultArea.append(Double.toString((interest * lastAmount)+lastAmount) +"\n");
            }
        });
    }

    private void createPanel() {
        JScrollPane scrollPane = new JScrollPane(resultArea);
        JPanel panel = new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(scrollPane);
        panel.add(button);
        add(panel);
    }
}
