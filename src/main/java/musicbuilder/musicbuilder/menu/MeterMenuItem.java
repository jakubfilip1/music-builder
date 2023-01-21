package musicbuilder.musicbuilder.menu;

import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import musicbuilder.musicbuilder.config.Meter;

public class MeterMenuItem extends MenuItem {

    public MeterMenuItem(Meter meter)
    {
        super();

        this.model = meter;

        setImage(this.model.urlImage);
    }
}
