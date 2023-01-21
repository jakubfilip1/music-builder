package musicbuilder.musicbuilder;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Note extends Staff {

    protected Text clef;

    public String tekst;

    public String notation;

    public String dzwiek;


    public Note()
    {
        super();

        clef = new Text();

        clef.setText("\uE4E3");
        notation = "Rw";
        clef.setTranslateY(-40);

        this.getChildren().add(clef);
    }

    protected void setPosition(String text, double y)
    {
        if(text.contains("R"))
        {
            clef.setTranslateY(-40);
            return;
        }

        double clickPosition = y - this.getStaffMinY();
        int line = 0;

        if(clickPosition > 0 && clickPosition < 90) {

            double lineHeight = (90) / 9;
            line = (int) (clickPosition / lineHeight);
        }
        line++;

        line = 9 - line;

        clef.setTranslateY(-10 * line);

        switch(line)
        {
            case 0:
                dzwiek = "E";
                break;
            case 1:
                dzwiek = "F";
                break;
            case 2:
                dzwiek = "G";
                break;
            case 3:
                dzwiek = "A";
                break;
            case 4:
                dzwiek = "B";
                break;
            case 5:
                dzwiek = "C5";
                break;
            case 6:
                dzwiek = "D5";
                break;
            case 7:
                dzwiek = "E5";
                break;
            case 8:
                dzwiek = "F5";
                break;
            default:
                dzwiek = "G2";
        }
    }

    public void setNote(String text, double y)
    {
        clef.setText(Notation.getUnicode(text));
        this.dzwiek = null;
        this.notation = text;
        this.setPosition(text, y);
    }

    public boolean isPause()
    {
        return notation.contains("R");
    }

    public void setText(String text, int position)
    {
        position = 9 - position;

        System.out.println(position);

        clef.setTranslateY(-10 * position);

        clef.setText(text);
    }
}
