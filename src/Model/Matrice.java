package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Matrice implements ActionListener {

    //attributi
    private char[][] matrice;
    private ArrayList<String> words = new ArrayList<>();

    //costruttore
    public Matrice() {
        this.matrice = new char[5][5];
    }

    //getter and setter
    public ArrayList<String> getWords() {
        return words;
    }
    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
    public char[][] getMatrice() {
        return matrice;
    }
    public void setMatrice(char[][] matrice) {
        this.matrice = matrice;
    }

    public void caricaMatrice() {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.matrice[i][j] = alphabet.charAt(r.nextInt(alphabet.length()));
            }
        }
    }
    public void visualMatrice() {
        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice[i].length; j++) {
                System.out.print("\t" + matrice[i][j]);
            }
            System.out.println();
        }
    }
    public void caricaFileToArray() {
        File fileDizi = new File("src/model/Dizionario.txt"); // Replace "file.txt" with the path to your text file
        Scanner scanner = null;
        try {
            scanner = new Scanner(fileDizi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
        }

        scanner.close();

        // Print the contents of the array to check that it worked
        /*for (String word : words) {
            System.out.println(word);
        }*/
    }

    //ricercaParolaInMatriceButton
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getText();
        System.out.println("Hai cliccato il bottone: " + buttonName);
    }

    // Custom listener class to handle input events
    public static class InputListener implements Runnable {
        private char input;

        public void run() {
            Scanner scanner = new Scanner(System.in);

            // Continuously read input from the scanner and signal an event when input is received
            while (true) {
                if (scanner.hasNext()) {
                    synchronized (this) {
                        input = scanner.next().charAt(0);
                        notify();
                    }
                }
            }
        }

        public char getInput() {
            return input;
        }
    }
    public void ricercaParolaInMatriceTastiera() {
        Scanner scanner = new Scanner(System.in);
        InputListener listener = new InputListener();

        // Create a new thread for the InputListener and start it
        Thread listenerThread = new Thread(listener);
        listenerThread.start();

        // Register the listener with the scanner
        scanner.useDelimiter("");

        // Start the event loop
        while (true) {
            // Wait for the listener to signal an event
            System.out.print("Inserisci una stringa: ");
            synchronized (listener) {
                try {
                    listener.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Get the character from the listener and handle the event
            char c = listener.getInput();
            if (c == 'a') {
                System.out.println("A key pressed");
            } else if (c == 'b') {
                System.out.println("B key pressed");
            } else if (c == 'q') {
                System.out.println("Exiting program...");
                break;
            }
        }
        /*boolean parolaTrov = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisci una stringa: ");
            String inputString = scanner.nextLine();
            System.out.println("Hai inserito: " + inputString);

            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice.length; j++) {

                }
                String fruit = words.get(i);
                if (fruit.equals(inputString)) {
                    parolaTrov = true;
                    System.out.println("Parola Trovata");
                    break;
                }
            }
            if (parolaTrov == false) {
                System.out.println("Parola non Trovata");
            }
            scanner.close();
        } while (parolaTrov != true);*/
    }
}