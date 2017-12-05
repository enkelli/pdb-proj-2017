package cz.vutbr.fit.pdb.utils;

import com.airhacks.afterburner.views.FXMLView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

public class JavaFXUtils {
    public static void openModalDialog(Stage primaryStage, String title, FXMLView fxmlView) {
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlView.getView());
        stage.setTitle(title);
        stage.setScene(scene);

        // make the dialog modal
        stage.initOwner(primaryStage.getOwner());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public static void closeWindow(ActionEvent event) {
        ((Node) event.getSource()).getScene()
                                  .getWindow()
                                  .hide();
    }

    public static void showError(String title, String text) {
        Notifications.create()
                     .title(title)
                     .text(text)
                     .darkStyle()
                     .showError();
    }

    public static void showInfo(String title, String text) {
        Notifications.create()
                     .title(title)
                     .text(text)
                     .darkStyle()
                     .showInformation();
    }
}
