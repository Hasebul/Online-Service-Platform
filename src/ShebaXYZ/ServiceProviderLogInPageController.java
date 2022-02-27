package ShebaXYZ;

import Util.ModifyDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ShebaXYZ.ServiceProvider.serviceprovider;

public class ServiceProviderLogInPageController {

    private  Page mainPage;
    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Button backButton;

    @FXML
    private Button loginButton;

    @FXML
    void backOnAction(ActionEvent event) {

        mainPage.showMainPage();
    }

    @FXML
    void loginAction(ActionEvent event) {
        ModifyDatabase modifyDatabase=new ModifyDatabase();
        ResultSet rs=modifyDatabase.selectServiceProvider(userName.getText(),password.getText());
        try {
            if(rs.next())
            {
                serviceprovider=new ServiceProvider(rs.getString("PHONE"),rs.getString("PASSWORD"),rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getString("EMAIL"),rs.getString("SERVICE_SUBCATEGORY"),rs.getString("IS_IDLE"),rs.getString("RATING"),rs.getString("LOCATION_ID"));
                System.out.println(serviceprovider.fName+" "+serviceprovider.lName);
                mainPage.shewServiceProviderProfilePage();
            }
            else
            {

                System.out.println("not sucessfully update");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Phone number");
                alert.setHeaderText("Incorrect Username or password");
                alert.setContentText("Enter correct username or password .");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }

}
