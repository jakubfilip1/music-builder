package musicbuilder.musicbuilder;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Tact extends HBox {

    protected MainController controller;

    public void setController(MainController controller)
    {
        this.controller = controller;
    }

    public void newEmptyNote(Note previousNote)
    {
        int value = controller.meter.getMaxTactValue() - getValueWithout(new Note());

        while(value > 0)
        {
            Note note = new Note();

            String newNote = Notation.getNoteForValue(value);

            value -= Notation.getValue(newNote);

            note.setNote(newNote, 0);

            note.setOnMouseClicked(event -> controller.onMouseClick(event));

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
                value += Notation.getValue(((Note) note).notation);
            }
        }

        return value;
    }

    public void newMeter()
    {

    }
    public Tact()
    {
        this.getChildren().add(new Text("\uE030"));
    }
}
