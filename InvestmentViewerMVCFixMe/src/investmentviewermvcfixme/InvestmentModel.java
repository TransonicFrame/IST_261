package investmentviewermvcfixme;

/**
 * Based on program in Big Java: Late Objects by Cay Horstmann; modified
 */
public class InvestmentModel {

    private final double defaultRate;
    private final double initialBalance;

    private double balance;

    public InvestmentModel() {
        this.initialBalance = 1000;
        this.defaultRate = 5;
        this.balance = initialBalance;
    }
    
    public void calculation(){
        balance = ((((defaultRate / 100) * balance)+balance));
    }

    
    // just getters below

    /**
     * @return the defaultRate
     */
    public double getDefaultRate() {
        return defaultRate;
    }

    /**
     * @return the initialBalance
     */
    public double getInitialBalance() {
        return initialBalance;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

}
