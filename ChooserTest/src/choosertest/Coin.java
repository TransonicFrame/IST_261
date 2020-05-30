package choosertest;

public class Coin {

    private final String name;
    private final double value;

    public Coin(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return " I'm a coin; my name is " + name + "; my value is " + value;
    }
}
