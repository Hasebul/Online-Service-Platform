package ShebaXYZ;

import Util.ModifyDatabase;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

import static ShebaXYZ.ServiceProvider.serviceprovider;

public class ViewOrderProviderRequestController implements Initializable {
    private Page mainPage;
    String orderId;
    private List<OrderRequestTable> orderrequesttablelist = new ArrayList<>();
    @FXML
    private TableView<OrderRequestTable> tableview;
    ObservableList<OrderRequestTable> data;
    @FXML
    private TableColumn<OrderRequestTable,String> ordernumber;

    @FXML
    private TableColumn<OrderRequestTable,String> name;

    @FXML
    private TableColumn<OrderRequestTable,String> phone;

    @FXML
    private TableColumn<OrderRequestTable,String> service;

    @FXML
    private TableColumn<OrderRequestTable,String> price;

    @FXML
    private TableColumn<OrderRequestTable,String> address;
    @FXML
    private Button confirm;

    @FXML
    private Button cancel;



    @FXML
    private Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ordernumber.setCellValueFactory(new PropertyValueFactory<>("ordernumber"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        service.setCellValueFactory(new PropertyValueFactory<>("service"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        tableview.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener< OrderRequestTable>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends OrderRequestTable> observable,
                            OrderRequestTable oldValue,   OrderRequestTable newValue ) {
                            orderId=newValue.getOrdernumber();
                            System.out.println(orderId);


                    }
                });



        loadList();
        data = FXCollections.observableArrayList(orderrequesttablelist);
        tableview.setEditable(true);
        tableview.setItems(data);

    }


    @FXML
    void backOnAction(ActionEvent event) {
        mainPage.shewServiceProviderProfilePage();

    }
    void loadList()
    {
        ModifyDatabase m=new ModifyDatabase();
        ResultSet rs=m.selectViewProviderRequest(serviceprovider.phone);
        try{
            while (rs.next())
            {

                orderrequesttablelist.add(new OrderRequestTable(rs.getString("orderid"),rs.getString("username"),rs.getString("phone"),rs.getString("service"),rs.getString("price"),rs.getString("address")));

            }

        }catch (Exception e)
        {
            System.out.println(e);
        }


    }
    @FXML
    void cancelOnAction(ActionEvent event) {
      ModifyDatabase m=new ModifyDatabase();
      m.updateOrder(orderId,"false");
        System.out.println("ARE YOU SURE TO TO CANCEL");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("CANCEL");
        alert.setHeaderText("CANCEL");
        alert.setContentText("CANCEL");
        alert.showAndWait();
       mainPage.shewServiceProviderProfilePage();
    }

    @FXML
    void confirmOnAction(ActionEvent event) {
        ModifyDatabase m=new ModifyDatabase();
        m.updateOrder(orderId,"true");


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONFIRM");
        alert.setHeaderText("BOOKED");
        alert.setContentText("HAVE A NICE DAY !");
        alert.showAndWait();
        mainPage.shewServiceProviderProfilePage();

    }
    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }


}

