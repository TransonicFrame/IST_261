package csvtestapp;

public class GeographicRegion {

    private final String name;
    private final double area;

    public GeographicRegion(String name, double area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public String toString() {
        return "name: " + name + "; area: " + area + " sq. km";
    }
}
