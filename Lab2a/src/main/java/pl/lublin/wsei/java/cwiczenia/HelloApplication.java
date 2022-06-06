package pl.lublin.wsei.java.cwiczenia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader.load(getClass().getResource("gusInfoGraphic.fxml"));
        FXMLLoader loader = null;
        Parent root = loader.load();
        ModuleLayer.Controller controller = loader.getController();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gusInfoGraphic.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}