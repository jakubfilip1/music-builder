package musicbuilder.musicbuilder;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Staff extends StackPane {
    protected Text staff;

    public Staff()
    {
        staff = new Text("\uE01A");
        staff.setFont(new Font("Bravura", 40));

        this.getChildren().add(staff);
    }
    public Double getStaffMinY()
    {
        return staff.getBoundsInLocal().getMinY() + 235;
    }
}
