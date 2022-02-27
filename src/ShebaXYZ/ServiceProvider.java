package ShebaXYZ;

public class ServiceProvider {
    public String phone;
    public String password;
    public String fName;
    public String lName;
    public String email;
    public String serviceSubCategory;
    public String isIdle;
    public String rating;
    public String location;
    public static ServiceProvider serviceprovider;

    public ServiceProvider() {
    }

    public ServiceProvider(String phone, String password, String fName, String lName, String email, String serviceSubCategory, String isIdle, String rating, String location) {
        this.phone = phone;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.serviceSubCategory = serviceSubCategory;
        this.isIdle = isIdle;
        this.rating = rating;
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServiceSubCategory() {
        return serviceSubCategory;
    }

    public void setServiceSubCategory(String serviceSubCategory) {
        this.serviceSubCategory = serviceSubCategory;
    }

    public String getIsIdle() {
        return isIdle;
    }

    public void setIsIdle(String isIdle) {
        this.isIdle = isIdle;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
