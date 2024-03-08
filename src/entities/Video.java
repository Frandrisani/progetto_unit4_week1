package entities;

import interfaces.Brightness;
import interfaces.Playable;
import interfaces.Volume;

import java.util.Scanner;

public class Video extends MultimediaElement implements Brightness, Playable, Volume {
    //Attributi
    int duration;
    int volume;
    int brightness;

    //Costruttore
    public Video(String titolo) {
        super(titolo);
        //Valori di default
        this.duration = 0;
        this.volume = 4;
        this.brightness = 5;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void increasesBrightness() {
        if (this.brightness < 10) {
            this.brightness++;
            System.out.println("Luminosità attuale: " + "*".repeat(this.brightness));

        }else {System.out.println("Luminosità massima raggiunta");
    }
    }

    @Override
    public void decreasesBrightness() {
        if (this.brightness > 0 && this.brightness < 10) {
            this.brightness--;
            System.out.println("Luminosità attuale: " + "*".repeat(this.brightness));
        } else {
            System.out.println("Luminosità minima raggiunta");
    }}

    @Override
    public void play() {
        for (int i = 0; i < this.duration; i++) {
            System.out.println(getTitolo() + " Volume: " + "!".repeat(this.volume) + " Luminosità: " + "*".repeat(this.brightness));
        }

    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public void volumeUp() {
        if (this.volume < 10) {
        this.volume++;
        this.play();
    } else

    {
        System.out.println("Volume massimo raggiunto");
    }

    }

    @Override
    public void volumeDown() {
        if (this.volume > 0 && this.volume < 10) {
        this.volume--;
        this.play();
    } else

    {
        System.out.println("Volume minimo raggiunto");
    }
    }
}
