package ShebaXYZ;

public class Order {

    public String orderId;
    public String userId;
    public  String serviceId;
    public String serviceProvider;
    public  String Cost;
    public  String isAccepted;
    public String userLocation;
    public Order() {

    }

    public Order(String orderId, String userId, String serviceId, String serviceProvider, String cost, String isAccepted, String userLocation) {
        this.orderId = orderId;
        this.userId = userId;
        this.serviceId = serviceId;
        this.serviceProvider = serviceProvider;
        Cost = cost;
        this.isAccepted = isAccepted;
        this.userLocation = userLocation;
    }

    public Order(String orderId, String userId, String serviceId, String serviceProvider, String cost, String isAccepted) {
        this.orderId = orderId;
        this.userId = userId;
        this.serviceId = serviceId;
        this.serviceProvider = serviceProvider;
        Cost = cost;
        this.isAccepted = isAccepted;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        this.isAccepted = isAccepted;
    }
    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }
}
