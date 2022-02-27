package ShebaXYZ;

import Util.ModifyDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static ShebaXYZ.USER.user;


public class UserProfilePageController implements Initializable {



        private Page mainPage;

        @FXML
        private Label userName;



       @Override
       public void initialize(URL location, ResourceBundle resources) {
        userName.setText(user.fName+" "+user.lName);
       }

        @FXML
        void ServiceOnAction(ActionEvent event) {

                mainPage.showServiceCategoryPage();
        }

        @FXML
        void homeOnAction(ActionEvent event) {
              mainPage.showHistoryPage();
        }

        @FXML
        void logOutOnAction(ActionEvent event) {
              mainPage.showMainPage();
        }

        @FXML
        void canceledOrderOnAction(ActionEvent event) {
            mainPage.showViewCancelOrderPage();
        }
        @FXML
         void processingOnAction(ActionEvent event) {

           mainPage.showProcessingPage();
        }


        @FXML
        void pendingOnAction(ActionEvent event) {
                mainPage.showPendingServicePage();
        }
        void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }



}


