package ShebaXYZ;

import javafx.beans.property.SimpleStringProperty;

public class OrderRequestTable {

    private final SimpleStringProperty ordernumber;
    private final SimpleStringProperty name;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty service;
    private final SimpleStringProperty price;
    private final SimpleStringProperty address;

    public OrderRequestTable(String ordernumber, String name, String phone, String service, String price, String address) {
        this.ordernumber = new SimpleStringProperty(ordernumber);
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.service = new SimpleStringProperty(service);
        this.price = new SimpleStringProperty(price);
        this.address = new SimpleStringProperty(address);
    }

    public String getOrdernumber() {
        return ordernumber.get();
    }

    public SimpleStringProperty ordernumberProperty() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber.set(ordernumber);
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

    public String getService() {
        return service.get();
    }

    public SimpleStringProperty serviceProperty() {
        return service;
    }

    public void setService(String service) {
        this.service.set(service);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
