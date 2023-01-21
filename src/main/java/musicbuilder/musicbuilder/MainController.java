package musicbuilder.musicbuilder;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.text.Text;

public class MainController implements Initializable {

    @FXML
    protected BorderPane borderPane;
    @FXML
    protected ScrollPane leftMenu;
    @FXML
    protected ScrollPane Cent;
    @FXML
    protected VBox leftMenuItems;

    @FXML
    protected VBox vboxCent;
    @FXML
    protected FlowPane flowPane;

    protected Note selectedNoteStaff;

    protected NoteMenuItem selectedNote;
    protected Clef clef;
    protected Meter meter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        clef = new Clef("treble");
        meter = new Meter("4", "8");

        flowPane.getChildren().add(clef);
        flowPane.getChildren().add(meter);

        for(int i = 0; i < 10; i++)
        {
            Tact tact = new Tact();
            tact.setController(this);
            tact.newEmptyNote(null);
            flowPane.getChildren().add(tact);
        }
    }

    public void onMouseClick(MouseEvent mouseEvent) {

        System.out.println("dupa");

        Note staff = (Note) mouseEvent.getSource();

        Tact tact = (Tact) staff.getParent();

        int value = tact.getValueWithout(staff);

        value += Notation.getValue(selectedNote.note);

        if(value > meter.getMaxTactValue())
            return;

        staff.setNote(selectedNote.note, mouseEvent.getY());

        Play play = new Play(staff.dzwiek + staff.notation);
        play.start();

        tact.newEmptyNote(staff);
    }

    public void selectNute(MouseEvent mouseEvent) {
        NoteMenuItem noteMenuItem = (NoteMenuItem) mouseEvent.getSource();

        this.selectedNote = noteMenuItem;
    }

    public void play(MouseEvent mouseEvent) {
        String notation = "";

        for(Node tact : flowPane.getChildren())
        {
            if(tact instanceof Tact)
            {
                for (Node note : ((Tact) tact).getChildren())
                {
                    if(note instanceof Text)
                    {
                        continue;
                    }
                    if(((Note) note).dzwiek == null)
                    {
                        notation += ((Note) note).notation + " ";
                    }
                    else {
                        notation += ((Note) note).dzwiek + ((Note) note).notation + " ";
                    }
                }
            }
        }

        System.out.println(notation);

        Play play = new Play(notation);
        play.start();
    }

    public void onKeyPress(KeyEvent event) {
        System.out.println("Dupa");
    }

    public void changeMeter(MouseEvent mouseEvent) {
        MeterMenuItem meterMenuItem = (MeterMenuItem) mouseEvent.getSource();
        meter.setMeter(meterMenuItem.meterTop, meterMenuItem.meterBottom);

        for(Node tact : flowPane.getChildren())
        {
            if(!(tact instanceof Clef || tact instanceof Meter))
            {
                ((Tact) tact).newMeter();
            }
        }
    }
}