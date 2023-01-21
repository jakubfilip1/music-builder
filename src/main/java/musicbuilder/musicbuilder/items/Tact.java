package musicbuilder.musicbuilder.items;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import musicbuilder.musicbuilder.config.ConfigManager;
import musicbuilder.musicbuilder.controllers.MainController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tact extends HBox {

    protected MainController controller;

    public void setController(MainController controller)
    {
        this.controller = controller;
    }

    public void newEmptyNote(Note previousNote)
    {
        int value = controller.meter.getMaxTactValue() - getValueWithout(null);

        while(value > 0)
        {
            musicbuilder.musicbuilder.config.Note newNote = new ConfigManager().getRestForValue(value);

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
            if((!(note instanceof Text)) && note != noteWithout)
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
        int value = controller.meter.getMaxTactValue() - getValueWithout(note);

        System.out.println(value);

        if(value >= (1024 / model.value))
        {
            note.setNote(model, mouseY);
            newEmptyNote(note);
        }
        else
        {
            boolean now = false;

            ArrayList<Note> list = new ArrayList<>();

            for(Node note2 : getChildren())
            {
                if(note2 instanceof Note) {

                    if (now) {

                        System.out.println("Weszło w ogóle?");

                        if (!Objects.equals(((Note) note2).note.type, "rest")) {
                            break;
                        }

                        value += 1024 / ((Note) note2).note.value;

                        System.out.println(value);

                        list.add((Note) note2);

                        if (value >= (1024 / model.value)) {
                            getChildren().removeAll(list);
                            note.setNote(model, mouseY);
                            newEmptyNote(note);
                            break;

                        }
                    }

                    if (note2 == note) {
                        now = true;
                    }
                }
            }
        }
    }
    public Tact()
    {
        this.getChildren().add(new Text("\uE030"));
    }
}
