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

    @Override
    public void increasesBrightness() {
        if (this.brightness < 10) {
            this.brightness++;
            this.play();
        }else {System.out.println("Luminosità massima raggiunta");
    }
    }

    @Override
    public void decreasesBrightness() {
        if (this.brightness > 0 && this.brightness < 10) {
            this.brightness--;
            this.play();
        } else {
            System.out.println("Luminosità minima raggiunta");
    }}

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il titolo del video");
        this.setTitolo(scanner.next());
        System.out.println("Inserisci la durata del video");
        this.duration = scanner.nextInt();
        for (int i = 0; i < this.duration; i++) {
            System.out.println(getTitolo() + " Volume: " + "!".repeat(volume) + " Luminosità: " + "*".repeat(brightness));
        }
        scanner.close();
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
