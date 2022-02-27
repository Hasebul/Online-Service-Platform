package ShebaXYZ;
public class Location {
    private double longitude;
    private double latitude;
    public static Location userLocation;
    public String userLocationName;

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public Location(double latitude, double longitude) {
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    public double distanceTo(Location that) {
        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(that.latitude);
        double lon2 = Math.toRadians(that.longitude);

        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));


        double nauticalMiles = 60 * Math.toDegrees(angle);
        double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        int d=(int) statuteMiles*1609;
        return d;
    }


    public static void main(String[] args) {
        Location loc1 = new Location(23.727148,90.391927);
        Location loc2 = new Location(23.725575,90.398236);
        double distance = loc1.distanceTo(loc2);
        distance = Double.parseDouble(String.format("%.2f", distance));
        System.out.println(distance + " miles");

    }
}