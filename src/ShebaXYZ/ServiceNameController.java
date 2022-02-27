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
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static ShebaXYZ.ServiceList.*;
import static ShebaXYZ.Location.userLocation;


public class ServiceNameController implements Initializable  {

    private List<ServiceList> list = new ArrayList<>();
    List<String> listLocation=new ArrayList<>();
    ObservableList<String> listCOM;
    String sProvider=null;
    Location sLocation=null;
    private Page mainPage;
    @FXML
    private TableView<ServiceList> tableview;
    ObservableList<ServiceList> data;
    @FXML
    private TableColumn<ServiceList,String> CATEGORY;
    @FXML
    private Label serviceSubCategory;

    @FXML
    private Button back;
    @FXML
    private ComboBox<String> location;

    @FXML
    private Button confirm;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        serviceSubCategory.setText(servicesubcategory);
        CATEGORY.setCellValueFactory(new PropertyValueFactory<>("CATEGORY"));
        tableview.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<ServiceList>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends ServiceList> observable,
                            ServiceList oldValue, ServiceList newValue ) {
                        sProvider=newValue.getCATEGORY();
                        System.out.println(sProvider);

                       // mainPage.showServiceConfirmationPage();

                    }
                });
        loadlist();
        data = FXCollections.observableArrayList(list);
        tableview.setEditable(true);
        tableview.setItems(data);
        listCOM=FXCollections.observableArrayList(listLocation);
        this.location.setItems(listCOM);


    }

    void loadlist()
    {
        ModifyDatabase modifyDatabase=new ModifyDatabase();
        ResultSet rs=modifyDatabase.selectServiceName(servicesubcategory);
        try{
            while (rs.next()) list.add(new ServiceList(rs.getString("Service_Name")));
        }catch (Exception e)
        {
            System.out.println(e);
        }

        ResultSet r=modifyDatabase.selectLocation();
        try{
            while (r.next()) {
                listLocation.add(r.getString("NAME"));
              //  System.out.println("NAME");

            }
        }catch (Exception e)
        {
            System.out.println(e);
        }



    }

    @FXML
    void confirmOnAction(ActionEvent event) {


        ModifyDatabase m=new ModifyDatabase();
        ResultSet resultSet=m.totalSP(sProvider);
        int a=-10;
         try{
             if(resultSet.next()) a= resultSet.getInt("totalsp");
         }catch (Exception e)
         {
             System.out.println(e);
         }
        if(sProvider!=null && sLocation!=null && a>0)
        {
            servicename=sProvider;
            userLocation=sLocation;
            System.out.println(userLocation.userLocationName);
            mainPage.showServiceConfirmationPage();
        }
        else if(a<=0)
        {
            System.out.println("All service provider are booked");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("All service provider are booked");
            alert.setHeaderText("All service provider are booked");
            alert.setContentText("please try later");
            alert.showAndWait();

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

    @FXML
    void selectLocationOnActon(ActionEvent event) {
        ModifyDatabase m=new ModifyDatabase();
        ResultSet rl=m.selectLocationLatLon(location.getValue());
        try {
            if(rl.next())
            {
               sLocation=new Location(rl.getDouble("LATITUDE"),rl.getDouble("LONGITUDE"));
               sLocation.userLocationName=location.getValue();
               //System.out.println(sLocation.userLocationName);
              // System.out.println(userLocation);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backOnAction(ActionEvent event) {
        mainPage.showServiceSubCategoryPage();
    }

    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }
}

