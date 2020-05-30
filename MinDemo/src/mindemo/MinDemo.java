package mindemo;

import java.util.ArrayList;
import java.util.Collections;

public class MinDemo {

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(3);
        intList.add(7);
        intList.add(1);
        printMinimum(intList);
    }

    private static Integer calculateMinimum(ArrayList<Integer> intList) {
        int min = Collections.min(intList);
        return min;

    }

    private static void printMinimum(ArrayList<Integer> intList) {
        System.out.println("The minimum of " + intList.toString().replace("[", "").replace("]", "") + " is " + calculateMinimum(intList));
    }
}
