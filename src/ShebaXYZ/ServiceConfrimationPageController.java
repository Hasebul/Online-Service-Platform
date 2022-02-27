package ShebaXYZ;

import Util.ModifyDatabase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static ShebaXYZ.ServiceList.servicename;
import static ShebaXYZ.Location.userLocation;
import static ShebaXYZ.ServiceList.servicesubcategory;

public class ServiceConfrimationPageController implements Initializable {


    private Page mainPage;
    private Order orderNum=null;
    private List<WORKER> workerList=new ArrayList<>();
    private List<Integer> itemlist=new ArrayList<>();
    int item=1;
    int taka=0;
    ObservableList<Integer> itemNumberlist;

    @FXML
    private TableView<WORKER> tableview;
    ObservableList<WORKER> data;

    @FXML
    private TableColumn<Worker,String> name;

    @FXML
    private TableColumn<Worker,String> phone;

    @FXML
    private TableColumn<Worker,String> rating;

    @FXML
    private TableColumn<Worker,String> distance;

    @FXML
    private TableColumn<Worker,String> cost;

    @FXML
    private Button back;

    @FXML
    private Label user;

    @FXML
    private Button confirm;

    @FXML
    private Label orderItem;

    @FXML
    private ComboBox<Integer> amount;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.user.setText(USER.user.fName+" "+USER.user.lName);
        this.orderItem.setText(servicename);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tableview.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<WORKER>() {

                    public void changed(
                            ObservableValue<? extends WORKER> observable,
                            WORKER oldValue, WORKER newValue ) {
                            orderNum=new Order();
                            orderNum.serviceProvider=newValue.getPhone();
                            orderNum.userId=USER.user.getPhone()+"";
                            orderNum.isAccepted="false";
                            taka=Integer.parseInt(newValue.getCost(),10);


                    }
                });

        loadlist();
        data = FXCollections.observableArrayList(workerList);
        tableview.setEditable(true);
        tableview.setItems(data);
        itemNumberlist=FXCollections.observableArrayList(itemlist);
        amount.setItems(itemNumberlist);


    }

    @FXML
    void backOnAction(ActionEvent event) {
        mainPage.showServiceNamePage();
    }

    @FXML
    void confirmOnAction(ActionEvent event) {

        if(orderNum!=null)
        {
            confirmOrder();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("BOOKED");
            alert.setHeaderText("your order is done");
            alert.setContentText("please check your pending box to check the order conformation!");
            alert.showAndWait();
            mainPage.showUserProfilePage();

        }
        else
        {
            System.out.println("select service and Location");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("You don't select service or location");
            alert.setHeaderText("You don't select service or location");
            alert.setContentText("please select and services");
            alert.showAndWait();

        }
    }

    void setPage(Page mainPage) {
        this.mainPage = mainPage;
    }

    void loadlist()
    {
        ModifyDatabase m=new ModifyDatabase();
        ResultSet rs=m.selectWorker(servicename);
        try{
            while (rs.next())
            {
                Location providerLocation=new Location(rs.getDouble("lat"),rs.getDouble("lon"));
                double dis=userLocation.distanceTo(providerLocation);
                if(dis<=7000)
                {
                    workerList.add(new WORKER(rs.getString("fullname"),rs.getString("phone"),rs.getString("rating"),dis+"",((int)rs.getInt("price")+(int)(dis*.03))+"" ));
                }
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        itemlist.add(1);
        itemlist.add(2);
        itemlist.add(3);
        itemlist.add(4);
      //  itemlist.add(5);
      //  itemlist.add(6);

    }


    public void amountOnAction(ActionEvent actionEvent) {
        item=amount.getValue();
       // System.out.println(item);
    }

    public void confirmOrder()
    {
        ModifyDatabase m=new ModifyDatabase();
        ResultSet rs=m.selectServiceID(servicename);
        try {
            if(rs.next())
            {
                orderNum.serviceId=rs.getString("SERVICE_ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        orderNum.Cost=item*taka+"";
        ResultSet r=m.selectLocationLatLon(userLocation.userLocationName);
        try {
            if(r.next())
            {
                orderNum.userLocation=r.getString("LOCATION_ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        m.insertOrder(orderNum);
    }
}

