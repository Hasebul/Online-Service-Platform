
package ShebaXYZ;

import Util.ModifyDatabase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewcancelOrderPageController implements Initializable {

    private Page mainPage;
    private String sid;
    List<CanceledOrder> list=new ArrayList<>();
    ObservableList<CanceledOrder> data;
    @FXML
    private TableView<CanceledOrder> tableview;

    @FXML
    private TableColumn<CanceledOrder,String> ordernumber;

    @FXML
    private TableColumn<CanceledOrder,String> name;

    @FXML
    private TableColumn<CanceledOrder,String> service;

    @FXML
    private TableColumn<CanceledOrder,String> comment;

    @FXML
    private Button back;

    @FXML
    private Button ok;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ordernumber.setCellValueFactory(new PropertyValueFactory<>("ordernumber"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        service.setCellValueFactory(new PropertyValueFactory<>("service"));
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));

        tableview.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener< CanceledOrder>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends CanceledOrder> observable,
                            CanceledOrder oldValue,   CanceledOrder newValue ) {
                             System.out.println(newValue.getOrdernumber());
                             sid=newValue.getOrdernumber();

                    }
                });


        loadlist();
        data= FXCollections.observableArrayList(list);
        tableview.setEditable(true);
        tableview.setItems(data);


    }

    @FXML
    void backOnAction(ActionEvent event) {
          mainPage.showUserProfilePage();
    }

    @FXML
    void okOnAcction(ActionEvent event) {

        ModifyDatabase m=new ModifyDatabase();
        m.deleteOId(sid);
        System.out.println("ARE YOU SURE TO TO CANCEL");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Deleted");
        alert.setHeaderText("Deleted");
        alert.setContentText("deleted");
        alert.showAndWait();
        mainPage.showUserProfilePage();
    }

    void loadlist()
    {
        ModifyDatabase m=new ModifyDatabase();
        ResultSet rs=m.selectCancelOrderOrProcessOrder(USER.user.phone+"","= FALSE");
      //  System.out.println("problem ");
        try{
            while (rs.next())
            {
                list.add(new CanceledOrder(rs.getString("oid"),rs.getString("service"),rs.getString("provider_name"),"IS CANCELED"));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }


}
