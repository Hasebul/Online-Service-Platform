package ShebaXYZ;

public class USER {


    public int phone;
    public String password;
    public  String fName;
    public String lName;
    public String email;
    public  String jDate;
    public static USER user;

    public USER() {
    }

    public USER(int phone, String password, String fName, String lName, String email, String jDate) {
        this.phone = phone;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.jDate = jDate;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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

    public String getjDate() {
        return jDate;
    }

    public void setjDate(String jDate) {
        this.jDate = jDate;
    }

    @Override
    public String toString() {
        return "USER{" +
                "phone=" + phone +
                ", password='" + password + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", jDate='" + jDate + '\'' +
                '}';
    }
}
