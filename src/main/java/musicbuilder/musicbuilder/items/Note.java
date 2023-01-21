package musicbuilder.musicbuilder.items;

import javafx.scene.text.Text;
import musicbuilder.musicbuilder.config.Model;

public class Note extends Staff {

    protected musicbuilder.musicbuilder.config.Note note;
    protected Text text;

    protected String sound;

    public Note(musicbuilder.musicbuilder.config.Note model, double mouseY)
    {
        super();

        setNote(model, mouseY);
    }

    public void setNote(Model model, double mouseY)
    {
        musicbuilder.musicbuilder.config.Note note = (musicbuilder.musicbuilder.config.Note) model;

        this.note = note;

        this.getChildren().remove(text);

        text = new Text();

        text.setText(note.unicode);

        if(!this.note.notation.contains("R"))
        {
            text.setTranslateY(-10 * getLine(mouseY));
        }
        else
        {
            text.setTranslateY(-40);
        }

        sound = getSound(getLine(mouseY));

        this.getChildren().add(text);
    }
}
