package Model;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class INSdizionario {
    public static void main(String[] args) {
        // Crea un ArrayList vuoto per le parole
        String INPUT = "zuppero";
        boolean check = false;

        try {
            // Crea uno Scanner per il file di input
            Scanner scanner = new Scanner(new File(System.getProperty("user.dir")+"/src/Model/Dizionario.txt"));

            // Leggi ogni parola dal file e aggiungila all'ArrayList
            while (scanner.hasNext() && !check) {
                String parola = scanner.next();
                if(parola.equals(INPUT)){
                    check=true;
                }
            }

            if(check){
                System.out.println("PAROLA TROVATA");
            }

            // Chiudi lo scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            // Gestisci l'eccezione se il file non esiste
            e.printStackTrace();
        }
    }
}