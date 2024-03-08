package entities;

import interfaces.Brightness;
import interfaces.Unplayable;

//Creoiamo la classe Image, che estende MultimediaElement e implementa le interfacce Unplayable (non riproducibile) e Brightness
// (che contiene i metodi per aumentare e diminuire la luminosità).
public class Image extends MultimediaElement implements Unplayable, Brightness {
    //Attributi

    private int luminosita;
    //Costruttore
    public Image(String titolo, int durata) {
        //"Super" --> in riferimento al costruttore della classe MultimediaElement
        super(titolo);
        this.luminosita = 5; //inserisco un parametro di luminosità di partenza
    }

    //Metodi
    @Override
    public void show() {
        System.out.println("Titolo: " + this.getTitolo() + " Luminosità: " + this.luminosita);
    }

    @Override
    public void increasesBrightness() {
        //Aumento della luminosità di 1
        this.luminosita++;
        this.show();
        //Perchè non faccio scegliere all'utente quale valore aumentare?
        //Per non creare errori e bug di codice, limito la libertà di scelta dell'utente e rendo più controllato l'input
    }

    @Override
    public void decreasesBrightness() {
        //Diminuisco la luminosità di 1
        this.luminosita--;
        this.show();

    }
}
