package musicbuilder.musicbuilder;

import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MeterMenuItem extends VBox {

    public String meterTop;
    public String meterBottom;

    public MeterMenuItem(@NamedArg("url") String url, @NamedArg("meterTop") String meterTop, @NamedArg("meterBottom") String meterBottom)
    {
        super();

        this.meterTop = meterTop;
        this.meterBottom = meterBottom;

        this.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView();
        Image image = new Image(url);

        imageView.setImage(image);

        imageView.setFitHeight(70);
        imageView.setFitWidth(70);

        this.getChildren().add(imageView);
    }
}
