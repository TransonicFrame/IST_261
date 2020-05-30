package calendarapp.Controller;

import calendarapp.Model.Model;
import calendarapp.View.View;
import calendarapp.model.Weather;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private final Model model;
    private final ArrayList<String> stringArrayList;

    public Controller() {
        model = new Model();
        Weather weather = new Weather();
        stringArrayList = new ArrayList<>();
        for (int i = 0; i < model.getEventList().getEventArrayList().size(); i++) {
            stringArrayList.add(model.getEventList().getEventArrayList().get(i).toString());
        }

        View view;
        try {
            view = new View(model.getDateToday().toString(), stringArrayList, model.getDateToday().getDateHashMap(), weather.getDayHashMap(), this);
            view.setUpTodayView();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void writeToFile(ArrayList<String> eventArrayListOut) {
        try {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("EventData.txt"))) {
                for (int i = 0; i < eventArrayListOut.size(); i++) {
                    bufferedWriter.write(eventArrayListOut.get(i));
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
