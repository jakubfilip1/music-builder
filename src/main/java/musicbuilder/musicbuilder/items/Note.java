package musicbuilder.musicbuilder.items;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import musicbuilder.musicbuilder.config.Model;

import java.util.ArrayList;

public class Note extends Staff {

    public musicbuilder.musicbuilder.config.Note note;
    protected Text text;

    public String sound;

    protected ArrayList<Text> tempStaves;

    public Note(musicbuilder.musicbuilder.config.Note model, double mouseY)
    {
        super();

        tempStaves = new ArrayList<>();
        setNote(model, mouseY);
    }

    public void setNote(Model model, double mouseY)
    {
        musicbuilder.musicbuilder.config.Note note = (musicbuilder.musicbuilder.config.Note) model;

        this.note = note;

        this.getChildren().remove(text);

        text = new Text();

        if((getLine(mouseY) < 11) && (note.reverseUnicode != null))
        {
            text.setText(note.reverseUnicode);
        }
        else
        {
            text.setText(note.unicode);
        }

        if(!this.note.notation.contains("R"))
        {
            text.setTranslateY(5 * getLine(mouseY) - 70);
            sound = getSound(getLine(mouseY));
        }
        else
        {
            text.setTranslateY(-20);
            sound = null;
        }

        this.getChildren().add(text);
    }

    public void mouseEntered(MouseEvent event) {

        for(int i = 0; i < 3; i++)
        {
            Text text = new Text("\uE023");
            Text text2 = new Text("\uE023");
            text.setTranslateY(i * 10 + 10);
            text2.setTranslateY(i * -10 - 50);
            text.setOpacity(0.2);
            text2.setOpacity(0.2);
            tempStaves.add(text);
            tempStaves.add(text2);

            this.getChildren().add(text);
            this.getChildren().add(text2);

        }
    }

    public void mouseExited(MouseEvent event) {
        this.getChildren().removeAll(tempStaves);
        tempStaves.clear();
    }
}
