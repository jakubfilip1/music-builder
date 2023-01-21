package musicbuilder.musicbuilder.items;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import musicbuilder.musicbuilder.config.ConfigManager;
import musicbuilder.musicbuilder.controllers.MainController;

public class Tact extends HBox {

    protected MainController controller;

    public void setController(MainController controller)
    {
        this.controller = controller;
    }

    public void newEmptyNote(Note previousNote)
    {
        int value = controller.meter.getMaxTactValue() - getValueWithout(null);

        System.out.println(value);


        while(value > 0)
        {
            musicbuilder.musicbuilder.config.Note newNote = new ConfigManager().getNoteForValue(value);

            Note note = new Note(newNote, 0);

            value -= 1024 / newNote.value;

            note.setOnMouseClicked(event -> controller.addNote(event));

            if(previousNote == null)
            {
                this.getChildren().add(0, note);
            }
            else {
                this.getChildren().add(this.getChildren().indexOf(previousNote) + 1, note);
            }
        }
    }

    public int getValueWithout(Note noteWithout)
    {
        int value = 0;

        for(Node note : this.getChildren())
        {
            if(!(note instanceof Text) && (Note)note != noteWithout)
            {
                value += 1024 / ((Note) note).note.value;
            }
        }

        return value;
    }

    public void newMeter()
    {

    }

    public void addNote(Note note, musicbuilder.musicbuilder.config.Note model, double mouseY)
    {
        note.setNote(model, mouseY);
        newEmptyNote(note);
    }
    public Tact()
    {
        this.getChildren().add(new Text("\uE030"));
    }
}
