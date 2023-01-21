package musicbuilder.musicbuilder.items;

import javafx.scene.text.Text;
import musicbuilder.musicbuilder.config.Model;
import musicbuilder.musicbuilder.items.Staff;
import musicbuilder.musicbuilder.menu.ClefMenuItem;

public class Clef extends Staff {

    protected musicbuilder.musicbuilder.config.Clef clef;
    protected Text text;

    public Clef(Model model)
    {
        super();

        setClef(model);
    }

    public void setClef(Model model)
    {
        musicbuilder.musicbuilder.config.Clef clef = (musicbuilder.musicbuilder.config.Clef) model;
        this.clef = clef;

        this.getChildren().remove(text);

        text = new Text(this.clef.unicode);
        text.setTranslateY(-10 * clef.line);

        this.getChildren().add(text);
    }
}
