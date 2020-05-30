package calendarapp.Model;

public class Event {

    private final String eventName;
    private final String location;
    private final Date dateStart;
    private final Time timeStart;
    private final Date dateEnd;
    private final Time timeEnd;
    private final Boolean isAllDay;
    private final String description;

    public Event(String eventName, String location, Date dateStart, Time timeStart, Date dateEnd, Time timeEnd, Boolean isAllDay, String desrciption) {
        this.eventName = eventName;
        this.location = location;
        this.dateStart = dateStart;
        this.timeStart = timeStart;
        this.dateEnd = dateEnd;
        this.timeEnd = timeEnd;
        this.isAllDay = isAllDay;
        this.description = desrciption;
    }

    @Override
    public String toString() {
        return eventName + ", " + location + ", " + dateStart + ", " + timeStart + ", " + dateEnd + ", " + timeEnd + ", " + isAllDay + ", " + description;
    }
}
