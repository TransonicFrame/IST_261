package calendarapp.Model;

import java.util.ArrayList;

public class EventList {

    private final ArrayList<Event> eventArrayList;

    public EventList(Event event) {
        eventArrayList = new ArrayList<>();
        eventArrayList.add(event);
    }

    public ArrayList<Event> getEventArrayList() {
        return eventArrayList;
    }
}
