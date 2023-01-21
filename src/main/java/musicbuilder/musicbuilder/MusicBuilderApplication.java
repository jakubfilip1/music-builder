package musicbuilder.musicbuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MusicBuilderApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MusicBuilderApplication.class.getResource("views/main.fxml"));

        Rectangle2D displayBounds = Screen.getPrimary().getBounds();

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Music Builder");
        stage.setMaximized(true);
        stage.setMinHeight(720);
        stage.setMinWidth(1280);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}