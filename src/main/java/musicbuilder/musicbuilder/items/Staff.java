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
        String[] sounds = {"E", "D", "C", "H", "A", "G", "F", "E", "D", "C", "H", "A", "G", "F", "E", "D", "C", "H", "A", "G", "F", "E", "D", "C"};
        int sound = 0;
        int oktawa = 6;

        for(int i = 0; i < line; i++)
        {
            if(sounds[sound] == "C")
            {
                oktawa--;
            }

            sound++;
        }

        return sounds[sound] + oktawa;
    }

    public int getLine(double y)
    {
        double clickPosition = y - this.getStaffMinY();

        int line = 0;

        if(clickPosition > 0 && clickPosition < 210) {

            double lineHeight = (210) / 21;
            line = (int) ((clickPosition) / (lineHeight));
        }

        return line;
    }
    public Double getStaffMinY()
    {
        return staff.getBoundsInLocal().getMinY() + 177;
    }
}
