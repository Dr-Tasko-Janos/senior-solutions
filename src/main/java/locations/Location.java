package locations;


public class Location {

    private Long id;

    private String name;

    private double lat;

    private double lon;

    public Location(Long id, String name, double lat, double lon) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "{ ID: " + id + " - NAME: " + name + " (LAT: " + lat + ", LON: " + lon + ")";
    }
}
