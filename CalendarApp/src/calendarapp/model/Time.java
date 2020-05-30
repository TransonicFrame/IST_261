package calendarapp.Model;

public class Time {

    private final int hours;
    private final int mins;
    private final int secs;

    public Time(int hours, int mins, int secs) {
        this.hours = hours;
        this.mins = mins;
        this.secs = secs;
    }

    @Override
    public String toString() {
        return hours + ", " + mins + ", " + secs;
    }
}
