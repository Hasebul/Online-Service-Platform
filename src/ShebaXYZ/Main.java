package ShebaXYZ;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public void init()
    {

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Page mainpage=new Page();
        mainpage.setMainPage(primaryStage);
        mainpage.showMainPage();
    }

    public void stop()
    {

    }


    public static void main(String[] args) {
        launch(args);
    }
}
