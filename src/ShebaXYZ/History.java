package ShebaXYZ;

import javafx.beans.property.SimpleStringProperty;

public class History {

    private final SimpleStringProperty ordernumber;
    private final SimpleStringProperty service;
    private final SimpleStringProperty worker;
    private final SimpleStringProperty start_time;

    public History(SimpleStringProperty ordernumber, SimpleStringProperty service, SimpleStringProperty worker, SimpleStringProperty start_time) {
        this.ordernumber = ordernumber;
        this.service = service;
        this.worker = worker;
        this.start_time = start_time;
    }
}
