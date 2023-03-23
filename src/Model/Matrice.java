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
    private char[][] matrice;
    public Matrice() {
        this.matrice = new char[5][5];
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

        ArrayList<String> words = new ArrayList<>();

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
    public void ricercaParolaInMatriceTastiera() {
        boolean parolaTrov = false;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Inserisci una stringa: ");
            String inputString = scanner.nextLine();

            System.out.println("Hai inserito: " + inputString);

            scanner.close();
        } while (parolaTrov != true);
    }
}