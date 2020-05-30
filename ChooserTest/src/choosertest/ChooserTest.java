package choosertest;

import java.util.ArrayList;

public class ChooserTest {

    private static ArrayList<Coin> coinArrayList;

    public static void main(String[] args) {
        coinArrayList = new ArrayList<>();
        addCoins();
        Chooser<Coin> chooser = new Chooser<>(coinArrayList);
        for (int i = 0; i < 10; i++) {
            System.out.println(chooser.choose().toString());
        }
    }

    private static void addCoins() {
        coinArrayList.add(new Coin("penny", 0.01));
        coinArrayList.add(new Coin("nickel", 0.05));
        coinArrayList.add(new Coin("dime", 0.10));
        coinArrayList.add(new Coin("quarter", 0.25));
        coinArrayList.add(new Coin("half dollar", 0.50));
        coinArrayList.add(new Coin("dollar", 1.0));
    }
}
