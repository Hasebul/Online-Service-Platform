package ShebaXYZ;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static ShebaXYZ.ServiceProvider.serviceprovider;

public class ServiceProviderProfilePageController implements Initializable {

    private Page mainPage;
    @FXML
    private Button Service;

    @FXML
    private Button history;

    @FXML
    private Button logOut;

    @FXML
    private Label name;

    @FXML
    private Button order;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(serviceprovider.fName+" "+serviceprovider.lName);
         name.setText(serviceprovider.fName+" "+serviceprovider.lName);
       // patientName.setText(user.fName+" "+user.lName);

    }

    @FXML
    void ServiceOnAction(ActionEvent event) {

    }

    @FXML
    void historyOnAction(ActionEvent event) {

    }

    @FXML
    void logOutOnAction(ActionEvent event) {
          mainPage.showMainPage();
    }

    @FXML
    void orderOnAction(ActionEvent event) {

          mainPage.showViewProviderrequestpage();
    }
    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }


}

