package entities;

import interfaces.Playable;
import interfaces.Unplayable;

public class PlayerMultimediale {
    private MultimediaElement[] elementi;

    public PlayerMultimediale() {
        elementi = new MultimediaElement[5];
    }

    public void aggiungiElemento(MultimediaElement elemento, int posizione) {
        if (posizione >= 0 && posizione < elementi.length) {
            elementi[posizione] = elemento;
        }
    }

    public void eseguiElemento(int posizione) {
        if (posizione >= 0 && posizione < elementi.length) {
            MultimediaElement elemento = elementi[posizione];
            if (elemento instanceof Playable) {
                ((Playable) elemento).play();
            } else if (elemento instanceof Unplayable) {
                ((Unplayable) elemento).show();
            }
        }
    }

    public MultimediaElement[] getElementi() {
        return elementi;
    }
}
