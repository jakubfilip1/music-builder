package musicbuilder.musicbuilder.menu;

import musicbuilder.musicbuilder.config.Note;

public class NoteMenuItem extends MenuItem {

    public NoteMenuItem(Note note)
    {
        super();

        this.model = note;

        setImage(this.model.urlImage);
    }
}
