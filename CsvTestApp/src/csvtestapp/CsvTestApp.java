package csvtestapp;

import com.opencsv.CSVReaderHeaderAware;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CsvTestApp {

    private static ArrayList<GeographicRegion> geographicRegions;

    public static void main(String[] args) {
        geographicRegions = new ArrayList<>();
        addRegions();
        Chooser<GeographicRegion> chooser = new Chooser<>(geographicRegions);
        for (int i = 0; i < 10; i++) {
            System.out.println(chooser.choose().toString());
        }
    }

    private static void addRegions() {
        Map<String, String> values;
        try {
            CSVReaderHeaderAware headerAware = new CSVReaderHeaderAware(new FileReader("CSVData.csv"));

            while (((values = (Map<String, String>) headerAware.readMap())) != null) {
                String name = values.get("Country Name");
                double area = 0;
                if (values.get("2018") == null || values.get("2018").isEmpty()) {
                    area = 0.0;
                } else {
                    area = Double.parseDouble(values.get("2018"));
                }
                geographicRegions.add(new GeographicRegion(name, area));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
