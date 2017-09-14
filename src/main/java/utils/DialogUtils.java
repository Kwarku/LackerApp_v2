package utils;

import javafx.scene.control.Alert;

import java.util.ResourceBundle;

public class DialogUtils {


    private static ResourceBundle bundle = ResourceUtils.getResourceBundle();

    public static void errorDialog(String errorDescription, String consoleMessages){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(bundle.getString("error"));
        alert.setHeaderText(errorDescription);
        alert.setContentText(consoleMessages);
        alert.showAndWait();
    }
}
