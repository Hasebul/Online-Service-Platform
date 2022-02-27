package ShebaXYZ;


import Util.ModifyDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import java.awt.*;

import static ShebaXYZ.PendingSerivcePageController.oidupdateRecord;

public class RatingPageController {
    int i=0;
    private Stage stage=null;


    @FXML
    private TextArea comment;
    @FXML
    void OneOnAction(ActionEvent event) {
       i=1;
    }

    @FXML
    void ThreeOnAction(ActionEvent event) {
       i=3;
    }

    @FXML
    void finishOnAction(ActionEvent event) {
        String rate=null;
        if(i==0) rate="NULL";
        else rate=i+"";
        ModifyDatabase m=new ModifyDatabase();
        m.updateRecord(oidupdateRecord,rate,comment.getText());
        stage.close();


    }

    @FXML
    void fiveOnAction(ActionEvent event) {

        i=5;
    }

    @FXML
    void fourOnAction(ActionEvent event) {

        i=4;
    }

    @FXML
    void twoOnAction(ActionEvent event) {

        i=2;
    }
    @FXML
    void shebaOnAction(ActionEvent event) {

        ModifyDatabase m=new ModifyDatabase();
        if(m.checkEnoughBalance(oidupdateRecord))
        {
            String s=m.transactionAmmount(oidupdateRecord);
            System.out.println(s);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CONFIRM");
            alert.setHeaderText(s);
            alert.setContentText(s);
            alert.showAndWait();


        }
        else
        {
            System.out.println("You have not enough balance");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NOT ENOUGH BALANCE");
            alert.setHeaderText("NOT ENOUGH BALANCE");
            alert.setContentText("PLEASE PAY CASH");
            alert.showAndWait();

        }

    }



    void setStage(Stage s)
    {
        stage=s;
    }

}
