package calendarapp.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Date {

    private final int month;
    private final int day;
    private final int year;

    private final HashMap<Integer, ArrayList<Integer>> dateHashMap;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        dateHashMap = new HashMap<>();
    }

    public Date() {
        String date = java.time.LocalDate.now().toString();
        String[] dateArray = date.split("-");
        this.month = Integer.parseInt(dateArray[1]);
        this.day = Integer.parseInt(dateArray[2]);
        this.year = Integer.parseInt(dateArray[0]);
        dateHashMap = new HashMap<>();
        populateDateHashmap();
    }

    private HashMap<Integer, ArrayList<Integer>> populateDateHashmap() {
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 12; i++) {
            ArrayList<Integer> monthValues = new ArrayList<>();
            calendar.set(2019, i, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int maxNumberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            monthValues.add(dayOfWeek);
            monthValues.add(maxNumberOfDays);
            dateHashMap.put(i, monthValues);
        }

        return dateHashMap;
    }

    @Override
    public String toString() {
        return month + ", " + day + ", " + year;
    }

    public HashMap<Integer, ArrayList<Integer>> getDateHashMap() {
        return dateHashMap;
    }
}
