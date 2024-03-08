package entities;

import interfaces.Brightness;
import interfaces.Playable;
import interfaces.Unplayable;
import interfaces.Volume;

import java.util.Scanner;

public class PlayerMultimediale {
    private MultimediaElement[] elementi;

    public PlayerMultimediale() {
        //Con il 5 tra parentesi gli diciamo "accetta solo 5 elementi"
        elementi = new MultimediaElement[5];
    }

    public void aggiungiElemento(MultimediaElement elemento, int posizione) {
        //se posizione è >= 0 e < elementi.length assegno l'elemento alla posizione indicata nell' array
        if (posizione >= 0 && posizione < elementi.length) {
            elementi[posizione] = elemento;
        }
    }

    public void eseguiElemento(int posizione) {
        if (posizione >= 0 && posizione < elementi.length) {
            //inserisco -1 perchè la posizione inizia da 0 ma gli utenti selezionano da 1
            MultimediaElement elemento = elementi[posizione -1];
            //Controllo che l'elemento in questione da eseguire sia di tipo Playable
            if (elemento instanceof Playable) {
                Playable playableElement = (Playable) elemento;
                //lo eseguo e quindi mostro in console i vari dati
                playableElement.play();
                //una volta eseguito chiedo all'utente se vuole modificare luminosità o volume o tornare indietro nel caso non voglia fare nulla
                Scanner scanner = new Scanner(System.in);
                System.out.println("Vuoi modificare luminosità o volume? (luminosità = 1 /volume = 1/no = 0)");
                String scelta = scanner.nextLine();
                //se inserisce "l" allora controllo che l'elemento in questione sia di tipo Brightness, perchè come sappiamo non tutti
                //gli elementi "Playable" sono di tipo Brightness (come audio), quindi controllo che sia di tipo Brightness prima di eseguire il metodo increasesBrightness()
                if (scelta.equalsIgnoreCase("l")) {
                    if (elemento instanceof Brightness) {
                        Brightness brightnessElement = (Brightness) elemento;
                        System.out.println("Aumentare luminosità o abbassare la liminosità? (aumentare = 1 / abbassare = 2 / no = 0)");
                        String aumentaLuminosita = scanner.nextLine();
                        //se inserisce "1" (controllato da equalsIgnoreCase) allora eseguo il metodo increasesBrightness()
                        if (aumentaLuminosita.equalsIgnoreCase("1")) {
                            brightnessElement.increasesBrightness();
                            //inserisco il controllo dell'elese per non incorrere in bug o malfunzionamenti nel caso l'utente inserisca un valore non valido
                        } else if (aumentaLuminosita.equalsIgnoreCase("2")) {
                            brightnessElement.decreasesBrightness();
                        } else {System.out.println("Luminosità non modificata dato errato.");
                        }
                    } else {
                        System.out.println("Questo elemento non supporta la modifica della luminosità - Elemento Audio.");
                    }
                } else if (scelta.equalsIgnoreCase("2")) {
                    if (elemento instanceof Volume) {
                        Volume volumex = (Volume) elemento;
                        System.out.println("Aumentare Volume o abbassare Volume? (aumentare = 1 / abbassare = 2 / no = 0)");
                        String aumentaVolume = scanner.nextLine();
                        if (aumentaVolume.equalsIgnoreCase("1")) {
                            volumex.volumeUp();
                        } else if (aumentaVolume.equalsIgnoreCase("2")) {
                            volumex.volumeDown();
                        }
                    }else {System.out.println("Questo elemento non supporta la modifica del volume EERORE");
                }
                }
            } else if (elemento instanceof Unplayable) {
                ((Unplayable) elemento).show();
                //facciamo la stessa cosa anche per gli elementi non playable; loro è vero che non hanno volume però hanno luminosità
                //quindi procedo con la richiesta all'utente per modificare la luminosità, eventualmente
                Scanner scanner = new Scanner(System.in);
                System.out.println("vuoi modificare la luminosità? (si = 1 / no = 0)");
                String aumentaLuminositaperUnplayable = scanner.nextLine();
                if (aumentaLuminositaperUnplayable.equalsIgnoreCase("1")) {
                    System.out.println("Aumentare luminosità o abbassare la liminosità? (aumentare = 1 / abbassare = 2 / no = 0)");
                    String aumentaLuminosita = scanner.nextLine();
                    if (aumentaLuminosita.equalsIgnoreCase("1")) {
                        ((Brightness) elemento).increasesBrightness();
                } else if (aumentaLuminosita.equalsIgnoreCase("2")) {
                    ((Brightness) elemento).decreasesBrightness();
                } else {
                    System.out.println("Luminosità non modificata");
                }
            }
            } else {
                System.out.println("Luminosità non modificata");
            }
            }
        }
    public MultimediaElement[] getElementi() {
        return elementi;
    }
    }




