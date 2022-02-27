package ShebaXYZ;

import javafx.beans.property.SimpleStringProperty;

public class ServiceList {
    private final SimpleStringProperty CATEGORY;
    public static String serviceCategory;
    public static String servicesubcategory;
    public static String servicename;

    public ServiceList(String CATEGORY) {
        this.CATEGORY = new SimpleStringProperty(CATEGORY);
    }

    public String getCATEGORY() {
        return CATEGORY.get();
    }

    public SimpleStringProperty CATEGORYProperty() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY.set(CATEGORY);
    }
}


