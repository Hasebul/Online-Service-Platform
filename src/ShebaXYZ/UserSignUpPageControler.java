package ShebaXYZ;

import Util.ModifyDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import static ShebaXYZ.USER.user;

public class UserSignUpPageControler extends Component {
    private  Page mainPage;
    public Button backHome;
    public TextField Phone;
    public TextField email;
    public TextField firstName;
    public TextField lastName;
    public TextField dob;
    public TextArea address;
    public Button submit;
    public ComboBox<?> gender;
    public PasswordField password;
    public TextArea joinDate;

    public void submitOnAction(javafx.event.ActionEvent actionEvent) {

        ModifyDatabase insertDatabase=new ModifyDatabase();
        if(insertDatabase.insertIntoUser(Phone.getText(),password.getText(),firstName.getText(),lastName.getText(),email.getText(),joinDate.getText()))
        {
            System.out.println("not sucessfully update");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Phone number");
            alert.setHeaderText("Incorrect Username or password");
            alert.setContentText("This Phone number is already exist please try unique one .");
            alert.showAndWait();
        }
        else
        {
            System.out.println(Phone.getText()+" upadate sucessfully");
            user=new USER(Integer.parseInt(Phone.getText(),10),password.getText(),firstName.getText(),lastName.getText(),email.getText(),joinDate.getText());
            mainPage.showUserProfilePage();
        }


    }

    public void userGenderAction(javafx.event.ActionEvent actionEvent) {
    }

    public void backHomeOnAction(javafx.event.ActionEvent actionEvent) {
        mainPage.showMainPage();
    }

    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }



}
