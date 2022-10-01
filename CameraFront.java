package Camerajavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CameraFront extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root= FXMLLoader.load(getClass().getResource("cameraFront.fxml"));
        stage.setScene(new Scene(root,689,374));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
