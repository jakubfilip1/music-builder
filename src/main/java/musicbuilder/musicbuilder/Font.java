package musicbuilder.musicbuilder;

import java.util.HexFormat;

public class Font {
    public static String getNote(String note, boolean reverse)
    {
        Integer unicode = 0xE1D4;

        switch(note)
        {
            case "w":
                unicode =  0xE1D2;
                break;
        }

        Character unicodeChar = (char)unicode.intValue();

        return unicodeChar.toString();
    }
}
