package musicbuilder.musicbuilder.menu;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import musicbuilder.musicbuilder.MusicBuilderApplication;
import musicbuilder.musicbuilder.config.Model;

public class MenuItem extends VBox {

    protected Model model;

    public void setImage(String urlImage)
    {

        urlImage = MusicBuilderApplication.class.getResource(urlImage).toString();

        this.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView();
        Image image = new Image(urlImage);

        imageView.setImage(image);

        imageView.setFitHeight(70);
        imageView.setFitWidth(70);

        this.getChildren().add(imageView);
    }

    public Model getModel()
    {
        return model;
    }
}
