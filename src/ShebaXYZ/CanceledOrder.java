package ShebaXYZ;

import javafx.beans.property.SimpleStringProperty;

public class CanceledOrder {

    private final SimpleStringProperty ordernumber;
    private final SimpleStringProperty name;
    private final SimpleStringProperty service;
    private final SimpleStringProperty comment;

    public CanceledOrder(String ordernumber, String name, String service,String comment) {
        this.ordernumber =new SimpleStringProperty(ordernumber);
        this.name =new SimpleStringProperty(name);
        this.service =new SimpleStringProperty(service);
        this.comment = new SimpleStringProperty(comment);
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

    public String getService() {
        return service.get();
    }

    public SimpleStringProperty serviceProperty() {
        return service;
    }

    public void setService(String service) {
        this.service.set(service);
    }

    public String getComment() {
        return comment.get();
    }

    public SimpleStringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }
}
