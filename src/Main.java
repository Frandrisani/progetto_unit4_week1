import entities.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stayintheflow = true;
        PlayerMultimediale lettore = new PlayerMultimediale();

        // Creazione di alcuni elementi multimediali
        Scanner scanner = new Scanner(System.in);
        int numElementi = 0;
        int action;

        do {
            System.out.println("Seleziona una modalità:");
            System.out.println("1: Inserisci media");
            System.out.println("2: Visualizza un file inserito");
            System.out.println("0: Esci");
            action = Integer.parseInt(scanner.nextLine());

            switch (action) {
                case 1:
                    if(numElementi < 5) {
                        System.out.println("Scegli il tipo di file da inserire: ");
                        System.out.println("1: Immagine");
                        System.out.println("2: Audio");
                        System.out.println("3: Video");
                        int tipoFile = Integer.parseInt(scanner.nextLine());

                        switch (tipoFile) {
                            case 1:
                                Image immagine = new Image("Default");
                                System.out.println("Inserisci il titolo dell'immagine: ");
                                immagine.setTitolo(scanner.nextLine());
                                lettore.aggiungiElemento(immagine, numElementi);
                                numElementi++;
                                break;
                            case 2:
                                Audio audio = new Audio("Default");
                                System.out.println("Inserisci il titolo dell'audio: ");
                                audio.setTitolo(scanner.nextLine());
                                System.out.println("Inserisci la durata dell'audio: ");
                                audio.setDuration(Integer.parseInt(scanner.nextLine()));
                                lettore.aggiungiElemento(audio, numElementi);
                                numElementi++;
                                break;
                            case 3:
                                Video video = new Video("Default");
                                System.out.println("Inserisci il titolo del video: ");
                                video.setTitolo(scanner.nextLine());
                                System.out.println("Inserisci la durata del video: ");
                                video.setDuration(Integer.parseInt(scanner.nextLine()));
                                lettore.aggiungiElemento(video, numElementi);
                                numElementi++;
                                break;
                            default:
                                System.out.println("Tipo di file non valido.");
                        }
                    } else {
                        System.out.println("Hai già inserito 5 elementi multimediali.");
                    }
                    break;
                case 2:
                    System.out.println("Seleziona l'elemento da visualizzare: seleziona da tastiera un numero da 1 a 5 ");
                    int posiz= Integer.parseInt(scanner.nextLine());
                    if (posiz >= 1 && posiz <= 5) {
                        lettore.eseguiElemento(posiz);
            } else{
                System.out.println("Elemento non valido.");
            }
                    break;
                case 0:
                    stayintheflow = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (stayintheflow);
    }
}