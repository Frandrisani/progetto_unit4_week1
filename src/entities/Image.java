package entities;

import interfaces.Brightness;
import interfaces.Unplayable;

import java.util.Scanner;

//Creoiamo la classe Image, che estende MultimediaElement e implementa le interfacce Unplayable (non riproducibile) e Brightness
// (che contiene i metodi per aumentare e diminuire la luminosità).
public class Image extends MultimediaElement implements Unplayable, Brightness {
    //Attributi

    private int luminosita;
    //Costruttore
    public Image(String titolo) {
        //"Super" --> in riferimento al costruttore della classe MultimediaElement
        super(titolo);
        this.luminosita = 5; //inserisco un parametro di luminosità di partenza
    }

    //Metodi
    @Override
    public void show() {
       Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il titolo dell'immagine");
        this.setTitolo(scan.nextLine());
        System.out.println("Titolo: " + this.getTitolo() + " Luminosità: " + " !".repeat(luminosita));

    }

    @Override
    public void increasesBrightness() {
        //Aumento della luminosità di 1
        if (this.luminosita < 10 && this.luminosita > 0){
            this.luminosita++;
            this.show();
            //Perchè non faccio scegliere all'utente quale valore aumentare?
            //Per non creare errori e bug di codice, limito la libertà di scelta dell'utente e rendo più controllato l'input
        }
        else {
            System.out.println("Errore: luminosità non può essere superiore a 10");

        }

    }

    @Override
    public void decreasesBrightness() {
        //Diminuisco la luminosità di 1
        if (this.luminosita > 0 && this.luminosita < 10){
            this.luminosita--;
            this.show();
        } else {
            System.out.println("Errore: luminosità non può essere negativa o superiore a 10");
        }

    }
}
