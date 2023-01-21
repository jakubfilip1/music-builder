package musicbuilder.musicbuilder;

import javafx.beans.NamedArg;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Meter extends Staff{
    protected Text meterTop;
    protected Text meterBottom;

    protected int valueTop;
    protected int valueBottom;

    public int getMaxTactValue()
    {
        return valueTop * Notation.getValue(Notation.getNoteForInt(valueBottom));
    }

    public void setMeter(String meterTop, String meterBottom)
    {
        this.getChildren().remove(this.meterTop);
        this.getChildren().remove(this.meterBottom);

        this.meterTop = new Text(Notation.getUnicode(meterTop));
        this.meterTop.setTranslateY(-60);

        this.meterBottom = new Text(Notation.getUnicode(meterBottom));
        this.meterBottom.setTranslateY(-20);

        this.valueTop = Integer.parseInt(meterTop);
        this.valueBottom = Integer.parseInt(meterBottom);

        this.getChildren().add(this.meterTop);
        this.getChildren().add(this.meterBottom);
    }

    public Meter(@NamedArg("meterTop") String meterTop, @NamedArg("meterBottom") String meterBottom)
    {
        super();
        setMeter(meterTop, meterBottom);
    }
}
