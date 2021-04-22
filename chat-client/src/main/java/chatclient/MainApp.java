package chatclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        String fxmlFile = "/fxml/sample.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("Чатище");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }
}
