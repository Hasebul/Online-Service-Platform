package ShebaXYZ;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.awt.*;

public class HomePageController extends Component {

    private  Page mainPage;

    public Pane pane;
    public Button service;
    public Button contact;
    public Button about;
    public   Button LogIn;
    public Button SignUP;

    public void service_action(javafx.event.ActionEvent actionEvent) {
        mainPage.showServiceProviderLogInPage();
    }

    public void contactOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void about_action(javafx.event.ActionEvent actionEvent) {
    }




    public void LogInOnAction(javafx.event.ActionEvent actionEvent) {
        mainPage.showUserLogInPage();
    }

    public void SignUpOnAction(ActionEvent actionEvent) {
        mainPage.showUserSignUpPage();
    }

    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }
}
