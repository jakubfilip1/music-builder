package musicbuilder.musicbuilder.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.text.Text;
import musicbuilder.musicbuilder.config.ConfigManager;
import musicbuilder.musicbuilder.items.Clef;
import musicbuilder.musicbuilder.items.Meter;
import musicbuilder.musicbuilder.items.Note;
import musicbuilder.musicbuilder.items.Tact;
import musicbuilder.musicbuilder.menu.ClefMenuItem;
import musicbuilder.musicbuilder.menu.MeterMenuItem;
import musicbuilder.musicbuilder.menu.NoteMenuItem;
import musicbuilder.musicbuilder.services.Play;

public class MainController implements Initializable {

    @FXML
    protected ToolBar toolBar;
    @FXML
    protected FlowPane flowPane;

    @FXML
    protected FlowPane clefs;
    @FXML
    protected FlowPane meters;

    protected musicbuilder.musicbuilder.config.Note selectedNote;

    protected ClefMenuItem defaultClef;
    protected MeterMenuItem defaultMeter;
    public Clef clef;
    public Meter meter;

    protected ConfigManager configManager;

    protected void setNotes()
    {
        List<musicbuilder.musicbuilder.config.Note> notes = configManager.getNotes();

        for(musicbuilder.musicbuilder.config.Note note : notes)
        {
            NoteMenuItem noteMenuItem = new NoteMenuItem(note);

            noteMenuItem.setOnMouseClicked(event -> selectNote(event));

            this.toolBar.getItems().add(noteMenuItem);
        }
    }

    protected void setClefs()
    {
        List<musicbuilder.musicbuilder.config.Clef> clefs = configManager.getClefs();

        for(musicbuilder.musicbuilder.config.Clef clef : clefs)
        {
            ClefMenuItem clefMenuItem = new ClefMenuItem(clef);

            if(defaultClef == null)
            {
                defaultClef = clefMenuItem;
            }

            clefMenuItem.setOnMouseClicked(event -> selectClef(event));

            this.clefs.getChildren().add(clefMenuItem);
        }
    }

    protected void setMeters()
    {
        List<musicbuilder.musicbuilder.config.Meter> meters = configManager.getMeters();

        for(musicbuilder.musicbuilder.config.Meter meter : meters)
        {
            MeterMenuItem meterMenuItem = new MeterMenuItem(meter);

            if(defaultMeter == null)
            {
                defaultMeter = meterMenuItem;
            }

            meterMenuItem.setOnMouseClicked(event -> selectMeter(event));

            this.meters.getChildren().add(meterMenuItem);
        }
    }

    protected void setWorkspace()
    {
        for(int i = 0; i < 10; i++)
        {
            Tact tact = new Tact();
            tact.setController(this);
            tact.newEmptyNote(null);
            flowPane.getChildren().add(tact);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        configManager = new ConfigManager();

        setNotes();
        setClefs();
        setMeters();

        clef = new Clef(defaultClef.getModel());
        meter = new Meter(defaultMeter.getModel());

        flowPane.getChildren().add(clef);
        flowPane.getChildren().add(meter);

        setWorkspace();
    }

    public void addNote(MouseEvent mouseEvent) {

        Note note = (Note) mouseEvent.getSource();
        Tact tact = (Tact) note.getParent();

        tact.addNote(note, selectedNote, mouseEvent.getY());
    }

    public void selectNote(MouseEvent mouseEvent) {
        NoteMenuItem noteMenuItem = (NoteMenuItem) mouseEvent.getSource();

        this.selectedNote = (musicbuilder.musicbuilder.config.Note) noteMenuItem.getModel();
    }

    public void play(MouseEvent mouseEvent) {
       /* String notation = "";

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
        play.start();*/
    }

    public void selectMeter(MouseEvent mouseEvent) {
        MeterMenuItem meterMenuItem = (MeterMenuItem) mouseEvent.getSource();
        meter.setMeter(meterMenuItem.getModel());

        for(Node tact : flowPane.getChildren())
        {
            if(!(tact instanceof Clef || tact instanceof Meter))
            {
                ((Tact) tact).newMeter();
            }
        }
    }

    public void selectClef(MouseEvent mouseEvent) {
        ClefMenuItem clefMenuItem = (ClefMenuItem) mouseEvent.getSource();

        clef.setClef(clefMenuItem.getModel());
    }
}