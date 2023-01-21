package musicbuilder.musicbuilder;

import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class NoteMenuItem extends VBox {

    public String note;
    public String noteUnicode;
    public String noteReverseUnicode;

    public NoteMenuItem(@NamedArg("url") String url, @NamedArg("note") String note)
    {
        super();

        noteUnicode = Font.getNote(note, false);
        noteReverseUnicode = Font.getNote(note, true);

        this.note = note;

        this.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView();
        Image image = new Image(url);

        imageView.setImage(image);

        imageView.setFitHeight(70);
        imageView.setFitWidth(70);

        this.getChildren().add(imageView);
    }
}
