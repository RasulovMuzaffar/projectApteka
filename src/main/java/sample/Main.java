package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/ui/login/login.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/sample/ui/statistic/statistic.fxml"));
        primaryStage.setTitle("Authorization");
        primaryStage.setScene(new Scene(root, 640,450));

//        primaryStage.initStyle(StageStyle.TRANSPARENT);


//        primaryStage.setMaximized(true);
        //primaryStage.setMinWidth(635);
        //        primaryStage.setMinHeight(450);
        //        primaryStage.setMaxWidth(635);
        //        primaryStage.setMaxHeight(450);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
