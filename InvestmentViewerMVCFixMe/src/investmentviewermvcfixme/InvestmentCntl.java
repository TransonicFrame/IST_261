package investmentviewermvcfixme;

/**
 * Based on program in Big Java: Late Objects by Cay Horstmann; modified
 */
public class InvestmentCntl {

    private final InvestmentModel model;
    private final InvestmentView view;

    public InvestmentCntl() {
        model = new InvestmentModel();
        view = new InvestmentView(this);
        view.setVisible(true);
    }

    public double getInitialBalance() {
        return model.getInitialBalance();
    }

    public double getDefaultRate() {
        return model.getDefaultRate();
    }
    
    public double getBalance(){
        model.calculation();
        return model.getBalance();
    }
}
