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
        this.volume = 4;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il titolo dell'audio");
        this.setTitolo(scanner.next());
        System.out.println("Inserisci la durata dell'audio");
        this.duration = scanner.nextInt();
            //Navigando su StackOverflow, ho trovato questo metodo che permette di ripetere un carattere senza usare cicli
            //"repeat" --> "https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string"
        for (int i = 0; i < this.duration; i++) {
            System.out.println(getTitolo() + " Volume: " + "!".repeat(volume));
        }
            scanner.close();

    }

    @Override
    public int getDuration() {
        return this.duration;
    }


    @Override
    public void volumeUp() {
        if (this.volume < 10) { this.volume += 1;
            this.play();
    }else{
            System.out.println("Il volume è già al massimo");
        }


    }

    @Override
    public void volumeDown() {
        if (this.volume > 0) { this.volume -= 1;
        this.play();}else

    {
        System.out.println("Il volume è già al minimo");
    }
    }
}
