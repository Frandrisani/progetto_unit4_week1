package entities;

public class MultimediaElement {

    //Attributi
    //Perchè ho inserito "protected" invece di "private"? --> Perchè così il titolo è privato e non è accessibile dall'esterno,
    // tranne che dalle classi che ereditano MultimediaElement (classi figle, insomma)
    protected String titolo;

    //Costruttore
    public MultimediaElement(String titolo) {

        this.titolo = titolo;
    }

    //Setter e getter per il titolo
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
