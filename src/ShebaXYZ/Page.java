package ShebaXYZ;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Page {

    Stage primaryStage;


    void setMainPage(Stage myStage)
    {
        primaryStage=myStage;
    }

    public void showMainPage()  {
        // FXML Loading using FXMLLoader

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HomePage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        HomePageController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();
    }

    public void showUserSignUpPage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UserSignUpPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        UserSignUpPageControler controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();
    }


    public void showUserProfilePage()
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UserProfilePage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        UserProfilePageController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }

    public void showUserLogInPage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UserLogInPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        UserLogInPageControler controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();


    }

    public void showServiceCategoryPage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ServiceCategory.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ServiceCategoryControler controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();


    }

    public void showServiceSubCategoryPage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ServiceSubCategory.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ServiceSubCategoryControler controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();
    }

    public void showServiceNamePage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ServiceName.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Loading the controller
        ServiceNameController controller = loader.getController();
        controller.setPage(this);
        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();
    }

    public void showPendingServicePage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("pendingSerivcePage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Loading the controller
        PendingSerivcePageController controller = loader.getController();
        controller.setPage(this);
        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();
    }

    public void showServiceConfirmationPage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ServiceConfrimationPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ServiceConfrimationPageController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();


    }

    public void showServiceProviderLogInPage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ServiceProviderLogInPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ServiceProviderLogInPageController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }
    public void shewServiceProviderProfilePage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ServiceProviderProfilePage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ServiceProviderProfilePageController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();


    }

    public void showViewProviderrequestpage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("viewOrderProviderRequestPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ViewOrderProviderRequestController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }
    public void showViewCancelOrderPage()
    {
       // System.out.println("problem  m1");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ViewcancelOrderPage.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ViewcancelOrderPageController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }

    public void showProcessingPage()
    {
        // System.out.println("problem  m1");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("processingPage.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProcessingPageController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();


    }
    public void showHistoryPage()
    {
        // System.out.println("problem  m1");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("histroyOnAction.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
       HistroyOnActionController controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();


    }





}
