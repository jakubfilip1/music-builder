package musicbuilder.musicbuilder;

public class Notation {
    public static String getUnicode(String note)
    {
        switch(note)
        {
            case "w":
                return "\uE1D2";
            case "h":
                return "\uE1D3";
            case "q":
                return "\uE1D5";
            case "i":
                return "\uE1D7";
            case "Rw":
                return "\uE4E3";
            case "Rh":
                return "\uE4E4";
            case "Rq":
                return "\uE4E5";
            case "Ri":
                return "\uE4E6";
            case "1":
                return "\uE081";
            case "2":
                return "\uE082";
            case "3":
                return "\uE083";
            case "4":
                return "\uE084";
            case "5":
                return "\uE085";
            case "6":
                return "\uE086";
            case "7":
                return "\uE087";
            case "8":
                return "\uE088";
            case "9":
                return "\uE089";
        }

        return "";
    }

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
            case "q":
            case "Rq":
                return 256;
            case "i":
            case "Ri":
                return 128;
        }

        return 1;
    }

    static public String getNoteForValue(int value)
    {
        if(value / 1024 >= 1) {
            return "Rw";
        }else if(value / 512 >= 1)
        {
            return "Rh";
        }
        else if(value / 256 >= 1)
        {
            return "Rq";
        }

        return "Ri";
    }

    static public String getNoteForInt(int value)
    {
        switch(value)
        {
            case 1:
                return "w";
            case 2:
                return "h";
            case 4:
                return "q";
            case 8:
                return "i";
        }

        return "w";
    }
}