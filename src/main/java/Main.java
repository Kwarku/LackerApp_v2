import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utils.ResourceUtils;

import java.io.File;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader loader = new FXMLLoader(Main.class.getClass().getResource("/fxml/MainView.fxml"));
//        Scene scene = new Scene(ResourceUtils.loadFXml("/fxml/MainView.fxml"),600,600);

        primaryStage.setScene(new Scene(ResourceUtils.loadFXml("/fxml/GameView.fxml"), 500, 600));
        primaryStage.setFullScreen(true);

        primaryStage.getIcons().add(new Image("logo jpg.jpg"));

        primaryStage.setTitle(ResourceUtils.getResourceBundle().getString("app.title"));
        File file = new File("style.css");
        primaryStage.getScene().getStylesheets().add("file:" + file);
        primaryStage.show();
    }
}
