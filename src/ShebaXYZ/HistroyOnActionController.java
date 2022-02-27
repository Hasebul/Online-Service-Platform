package ShebaXYZ;

import Util.ModifyDatabase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static ShebaXYZ.ServiceList.serviceCategory;
import static ShebaXYZ.USER.user;

public class HistroyOnActionController implements Initializable {

    public  static String oidupdateRecord;
    private Page mainPage;
    private List<Record> recordList = new ArrayList<>();
    @FXML
    private TableView<Record> tableview;
    ObservableList<Record> data;
    @FXML
    private TableColumn<Record,String> ordernumber;

    @FXML
    private TableColumn<Record,String> service;

    @FXML
    private TableColumn<Record,String> worker;

    @FXML
    private TableColumn<Record,String> start_time;

    @FXML
    private Button back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ordernumber.setCellValueFactory(new PropertyValueFactory<>("ordernumber"));

        service.setCellValueFactory(new PropertyValueFactory<>("service"));

        worker.setCellValueFactory(new PropertyValueFactory<>("worker"));

        start_time.setCellValueFactory(new PropertyValueFactory<>("start_time"));
        tableview.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Record>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends Record> observable,
                            Record oldValue,   Record newValue ) {
                        //System.out.println(newValue.getOrdernumber());
                        oidupdateRecord=newValue.getOrdernumber();
                        showUpdateRecordPage();

                    }
                });




        loadlist();
        data = FXCollections.observableArrayList(recordList);
        tableview.setEditable(true);
        tableview.setItems(data);
    }

    void loadlist() {
        ModifyDatabase m=new ModifyDatabase();
        ResultSet r=m.selectHistory(user.phone+"");
        try
        {
            while (r.next())
            {
                recordList.add(new Record(r.getString("ordernumber"),r.getString("service"),r.getString("worker"),r.getString("start_time")));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @FXML
    void backOnAction(ActionEvent event) {
        mainPage.showUserProfilePage();
    }

    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }
    void showUpdateRecordPage()
    {
        Stage primaryStage=new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RatingPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RatingPageController controller = loader.getController();
        controller.setStage(primaryStage);

        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


}
