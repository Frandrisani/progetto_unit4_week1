package entities;

import interfaces.Playable;
import interfaces.Volume;

import java.util.Scanner;

public class Audio extends MultimediaElement implements Playable, Volume {
    //Attributi
    int duration;
    int volume;

    public Audio(String titolo) {
        super(titolo);
        //Vslori di default
        this.duration = 0;
        this.volume = 40;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il titolo dell'audio");
        this.setTitolo(scanner.next());
        System.out.println("Inserisci la durata dell'audio");
        this.duration = scanner.nextInt();
        for (int i = 0; i < getDuration(); i++) {
            //Navigando su StackOverflow, ho trovato questo metodo che permette di ripetere un carattere senza usare cicli
            //"repeat" --> "https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string"
            System.out.println(getTitolo() + "!".repeat(volume));
        }
    }

    @Override
    public int getDuration() {
        return this.duration;
    }


    @Override
    public void volumeUp() {
        if (this.volume < 100) { this.volume += 10;
            this.play();
    }else{
            System.out.println("Il volume è già al massimo");
        }


    }

    @Override
    public void volumeDown() {
        if (this.volume > 0) { this.volume -= 10;
        this.play();}else

    {
        System.out.println("Il volume è già al minimo");
    }
    }
}
