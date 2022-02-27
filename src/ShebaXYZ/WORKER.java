package ShebaXYZ;

import javafx.beans.property.SimpleStringProperty;

public class WORKER {

    private final SimpleStringProperty name;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty rating;
    private  final SimpleStringProperty distance;
    private final SimpleStringProperty cost;

    public WORKER(String name, String phone, String rating, String distance, String cost) {
        this.name =new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.rating = new SimpleStringProperty(rating);
        this.distance =new SimpleStringProperty(distance);
        this.cost = new SimpleStringProperty(cost);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getRating() {
        return rating.get();
    }

    public SimpleStringProperty ratingProperty() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

    public String getDistance() {
        return distance.get();
    }

    public SimpleStringProperty distanceProperty() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance.set(distance);
    }

    public String getCost() {
        return cost.get();
    }

    public SimpleStringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }
}
