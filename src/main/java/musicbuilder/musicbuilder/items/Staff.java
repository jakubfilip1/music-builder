package musicbuilder.musicbuilder.items;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Staff extends StackPane {
    protected Text staff;

    public Staff()
    {
        staff = new Text("\uE01A");

        this.getChildren().add(staff);
    }

    public String getSound(int line)
    {
        String sound = "C";

        switch(line)
        {
            case 0:
                sound = "E";
                break;
            case 1:
                sound = "F";
                break;
            case 2:
                sound = "G";
                break;
            case 3:
                sound = "A";
                break;
            case 4:
                sound = "B";
                break;
            case 5:
                sound = "C5";
                break;
            case 6:
                sound = "D5";
                break;
            case 7:
                sound = "E5";
                break;
            case 8:
                sound = "F5";
                break;
        }

        return sound;
    }

    public int getLine(double y)
    {
        double clickPosition = y - this.getStaffMinY();
        int line = 0;

        if(clickPosition > 0 && clickPosition < 90) {

            double lineHeight = (90) / 9;
            line = (int) (clickPosition / lineHeight);
        }
        line++;

        line = 9 - line;

        return line;
    }
    public Double getStaffMinY()
    {
        return staff.getBoundsInLocal().getMinY() + 235;
    }
}
