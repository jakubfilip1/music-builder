package musicbuilder.musicbuilder;

import org.jfugue.player.Player;

public class Play extends Thread {

    protected String music;

    public Play(String music)
    {
        super();
        this.music = music;
    }

    @Override
    public void run() {
        Player player = new Player();

        player.play(this.music);
    }
}
