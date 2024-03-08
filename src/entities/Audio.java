package entities;

import interfaces.Playable;
import interfaces.Volume;

public class Audio extends MultimediaElement implements Playable, Volume {


    public Audio(String titolo) {
        super(titolo);
    }

    @Override
    public void play() {

    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public void volumeUp() {

    }

    @Override
    public void volumeDown() {

    }
}
