package calendarapp.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Model {

    private final EventList eventList;
    private final Date date;

    public Model() {
        eventList = new EventList(null);
        populateArrayList();
        date = new Date();
    }

    private void populateArrayList() {
        eventList.getEventArrayList().remove(0);
        try {
            Scanner scanner = new Scanner(new File("EventData.txt"));
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(", ");
                Boolean allday;
                allday = !dataSplit[14].equals("false");
                eventList.getEventArrayList().add(new Event(dataSplit[0], dataSplit[1], new Date(Integer.parseInt(dataSplit[2]), Integer.parseInt(dataSplit[3]), Integer.parseInt(dataSplit[4])), new Time(Integer.parseInt(dataSplit[5]), Integer.parseInt(dataSplit[6]), Integer.parseInt(dataSplit[7])), new Date(Integer.parseInt(dataSplit[8]), Integer.parseInt(dataSplit[9]), Integer.parseInt(dataSplit[10])), new Time(Integer.parseInt(dataSplit[11]), Integer.parseInt(dataSplit[12]), Integer.parseInt(dataSplit[13])), allday, dataSplit[15]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public EventList getEventList() {
        return eventList;
    }

    public Date getDateToday() {
        return date;
    }
}
