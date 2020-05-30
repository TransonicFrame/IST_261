package listgettimer;

import com.opencsv.CSVReaderHeaderAware;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * class to show the differences in the average time to get an item from an ArrayList versus a LinkedList
 * 
 * CSV data slightly modified from the main csv file at
 * http://api.worldbank.org/v2/en/indicator/AG.LND.TOTL.K2?downloadformat=csv
 * 
 * opencsv information from http://opencsv.sourceforge.net/
 * 
 */
public class ListGetTimer {

    private final ArrayList<GeographicRegion> theArrayList;
    private final LinkedList<GeographicRegion> theLinkedList;
    
    // number to compute average time of get operation
    private static final long NUMBER_OF_GETS = 1000000;
    
    public ListGetTimer() {   
        theArrayList = new ArrayList<>();
        theLinkedList = new LinkedList<>();
        addDataToLists(); 
    }

    public static void main(String[] args) {

        ListGetTimer timer = new ListGetTimer();

        long avgTimeToGetItemFromArrayList = timer.calcAvgTimeOfListGet(timer.theArrayList);
        long avgTimeToGetItemFromLinkedList = timer.calcAvgTimeOfListGet(timer.theLinkedList);

        System.out.println("The average time to get an item from the Array List is "
                + avgTimeToGetItemFromArrayList + " nanoseconds.");
        System.out.println("The average time to get an item from the Linked List is "
                + avgTimeToGetItemFromLinkedList + " nanoseconds.");
    }

    private void addDataToLists() {
        Map<String, String> values;
        try {
            CSVReaderHeaderAware headerAware = new CSVReaderHeaderAware(new FileReader("regionsAndAreas.csv"));
            
            while (((values = (Map<String, String>) headerAware.readMap())) != null) {
                String name = values.get("Country Name");
                double area = 0;
                if (values.get("2018") == null || values.get("2018").isEmpty()) {
                    area = 0.0;
                } else {
                    area = Double.parseDouble(values.get("2018"));
                }
                theArrayList.add(new GeographicRegion(name, area));
                theLinkedList.add(new GeographicRegion(name, area));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private long calcAvgTimeOfListGet(List<GeographicRegion> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_GETS; i++){
            list.get(1);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        return duration;
    }
}
