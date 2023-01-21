package musicbuilder.musicbuilder.menu;

import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import musicbuilder.musicbuilder.config.Clef;

public class ClefMenuItem extends MenuItem {

    public ClefMenuItem(Clef clef)
    {
        super();

        this.model = clef;

        setImage(this.model.urlImage);
    }
}
