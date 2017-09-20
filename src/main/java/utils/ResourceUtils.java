package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ResourceBundle;

public class ResourceUtils {

    public static ResourceBundle getResourceBundle(){
        return ResourceBundle.getBundle("bundles/messages");
    }

    public static Pane loadFXml(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(ResourceUtils.class.getClass().getResource(fxmlPath));
        loader.setResources(getResourceBundle());

        try {
            return loader.load();
        } catch (IOException e) {
            DialogUtils.errorDialog(getResourceBundle().getString("no.file"), e.getMessage());
        }
        return null;
    }

}
