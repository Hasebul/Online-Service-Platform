package ShebaXYZ;

import javafx.beans.property.SimpleStringProperty;

public class Record {

    private final SimpleStringProperty ordernumber;
    private final SimpleStringProperty service;
    private final SimpleStringProperty worker;
    private final SimpleStringProperty start_time;


    public Record(String ordernumb, String ser, String wor, String time) {
        ordernumber = new SimpleStringProperty(ordernumb);
        service = new SimpleStringProperty(ser);
        worker = new SimpleStringProperty(wor);
        start_time = new SimpleStringProperty(time);
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

    public String getService() {
        return service.get();
    }

    public SimpleStringProperty serviceProperty() {
        return service;
    }

    public void setService(String service) {
        this.service.set(service);
    }

    public String getWorker() {
        return worker.get();
    }

    public SimpleStringProperty workerProperty() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker.set(worker);
    }

    public String getStart_time() {
        return start_time.get();
    }

    public SimpleStringProperty start_timeProperty() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time.set(start_time);
    }
}
