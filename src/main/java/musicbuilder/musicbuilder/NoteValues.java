package musicbuilder.musicbuilder;

public class NoteValues {
    static public int getValue(String note)
    {
        switch(note)
        {
            case "w":
            case "Rw":
                return 1024;
            case "h":
            case "Rh":
                return 512;
            case "i":
            case "Ri":
                return 128;
            case "q":
            case "Rq":
                return 64;
        }

        return 1;
    }
}
