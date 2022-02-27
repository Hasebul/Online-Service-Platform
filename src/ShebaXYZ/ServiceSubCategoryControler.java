package ShebaXYZ;

import Util.ModifyDatabase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static ShebaXYZ.ServiceList.serviceCategory;
import static ShebaXYZ.ServiceList.servicesubcategory;

public class ServiceSubCategoryControler implements Initializable {

    private List<ServiceList> list = new ArrayList<>();
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        serviceSubCategory.setText(serviceCategory);
        CATEGORY.setCellValueFactory(new PropertyValueFactory<>("CATEGORY"));
        tableview.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<ServiceList>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends ServiceList> observable,
                            ServiceList oldValue, ServiceList newValue ) {
                        servicesubcategory=newValue.getCATEGORY();
                        System.out.println(servicesubcategory);
                        mainPage.showServiceNamePage();

                    }
                });
        loadlist();
        data = FXCollections.observableArrayList(list);
        tableview.setEditable(true);
        tableview.setItems(data);



    }

    void loadlist()
    {
        ModifyDatabase modifyDatabase=new ModifyDatabase();
        ResultSet rs=modifyDatabase.selectServiceSubCategory(serviceCategory);
        try{
            while (rs.next()) list.add(new ServiceList(rs.getString("Service_SubCategory")));
        }catch (Exception e)
        {
            System.out.println(e);
        }



    }


    @FXML
    void backOnAction(ActionEvent event) {
        mainPage.showServiceCategoryPage();
    }

    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }


}
