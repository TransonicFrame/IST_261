package investmentviewermvcfixme;

/**
 * Based on program in Big Java: Late Objects by Cay Horstmann; modified
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InvestmentView extends JFrame {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 250;

    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;

    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private final JTextArea resultArea;

    private final InvestmentCntl cntl;

    public InvestmentView(InvestmentCntl investmentCntl) {
        cntl = investmentCntl;

        resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        resultArea.setText(cntl.getInitialBalance() + "\n");
        resultArea.setEditable(false);

        createTextField();
        createButton();
        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createTextField() {
        rateLabel = new JLabel("Interest Rate: ");
        final int FIELD_WIDTH = 10;
        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText("" + cntl.getDefaultRate());
    }

    private void createButton() {
        button = new JButton("Add Interest");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String[] resultArray = resultArea.getText().split("\\s+");
                //double lastAmount = Double.parseDouble(resultArray[resultArray.length - 1]);
                //double interest = Double.parseDouble(rateField.getText()) / 100;
                //resultArea.append(Double.toString((interest * lastAmount)+lastAmount) +"\n");
                resultArea.append(Double.toString(cntl.getBalance()) +"\n");
            }
        });
    }
    
    private void createPanel() {
        JPanel panel = new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(button);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);
        add(panel);
    }

}
