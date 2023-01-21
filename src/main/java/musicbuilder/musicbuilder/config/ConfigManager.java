package musicbuilder.musicbuilder.config;

import com.google.gson.Gson;
import musicbuilder.musicbuilder.MusicBuilderApplication;
import musicbuilder.musicbuilder.controllers.MainController;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class ConfigManager {
    protected Config config;
    public ConfigManager()  {
        configInit();
    }

    protected void configInit()
    {
        InputStream inputStream = MusicBuilderApplication.class.getResourceAsStream("views/config.json");

        Gson gson = new Gson();

        try
        {
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            config = gson.fromJson(reader, Config.class);
        }
        catch(UnsupportedEncodingException e)
        {

        }
    }

    public List<Note> getNotes()
    {
        return config.notes;
    }

    public List<Clef> getClefs()
    {
        return config.clefs;
    }

    public List<Meter> getMeters()
    {
        return config.meters;
    }

    public Note getRestForValue(int value)
    {
        for (Note note : getNotes())
        {
            if(Objects.equals(note.type, "rest") && (value >= (1024 / note.value)))
            {
                return note;
            }
        }

        return null;
    }
}
