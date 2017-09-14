import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.ResourceUtils;

import java.io.File;
import java.util.ResourceBundle;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getClass().getResource("/view/MainView.fxml"));
        Scene scene = new Scene(loader.load(),600,600);

        primaryStage.setScene(scene);
//        primaryStage.setFullScreen(true);

        primaryStage.setTitle(ResourceUtils.getResourceBundle().getString("app.title"));
        File file = new File("style.css");
        scene.getStylesheets().add("file:" + file);
        primaryStage.show();
    }
}
