package musicbuilder.musicbuilder.items;

import javafx.scene.Node;
import javafx.scene.text.Text;
import musicbuilder.musicbuilder.config.ConfigManager;
import musicbuilder.musicbuilder.config.Model;

public class Meter extends Staff {

    protected musicbuilder.musicbuilder.config.Meter meter;
    protected Text meterTop;
    protected Text meterBottom;

    public int getMaxTactValue()
    {
        ConfigManager configManager = new ConfigManager();

        int value = meter.top * (1024 / meter.bottom);

        return value;
    }

    public void setMeter(Model model)
    {
        musicbuilder.musicbuilder.config.Meter meter = (musicbuilder.musicbuilder.config.Meter) model;

        this.meter = meter;

        this.getChildren().remove(this.meterTop);
        this.getChildren().remove(this.meterBottom);

        this.meterTop = new Text(this.meter.topUnicode);
        this.meterTop.setTranslateY(-60);

        this.meterBottom = new Text(this.meter.bottomUnicode);
        this.meterBottom.setTranslateY(-20);

        this.getChildren().add(this.meterTop);
        this.getChildren().add(this.meterBottom);
    }

    public Meter(Model model)
    {
        super();
        setMeter(model);
    }
}
