package musicbuilder.musicbuilder;

import javafx.beans.NamedArg;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Clef extends Staff {

    protected Text clef;

    public Clef(@NamedArg("clefType") String clefType)
    {
        super();

        clef = new Text();

        switch(clefType)
        {
            case "bass":
                clef.setText("\uE062");
                clef.setTranslateY(-60);
                break;
            case "alto":
                clef.setText("\uE05C");
                clef.setTranslateY(-40);
                break;
            case "treble":
            default:
                clef.setText("\uE058");
                clef.setTranslateY(-20);
                break;

        }

        this.getChildren().add(clef);
    }
}
