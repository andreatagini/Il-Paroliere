package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Matrice implements ActionListener {

    //attributi
    private char[][] matrice;
    private ArrayList<String> words = new ArrayList<>();

    //costruttore
    public Matrice() {
        this.matrice = new char[10][10];
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
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                this.matrice[i][j] = alphabet.charAt(r.nextInt(alphabet.length()));
            }
        }
        this.matrice[0][0] = 'c';
        this.matrice[0][1] = 'i';
        this.matrice[0][2] = 'a';
        this.matrice[0][3] = 'o';
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
    /*public static class InputListener implements Runnable {
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
    }*/
    public static boolean areAllTrue(Boolean[] array)
    {
        for(boolean b : array) if(!b) return false;
        return true;
    }
    public static boolean isValidIndex(char[][] arr, int col, int row) {
        return col >= 0 && col < arr.length && row >= 0 && row < arr[0].length;
    }
    public static boolean isIndexOutOfRange(int index, int arrayLength) {
        return index < 0 || index >= arrayLength;
    }
    public boolean ricercaParolaInDizionario(String parola) {
        for (int x = 0; x < words.size(); x++) {
            if (words.get(x).equals(parola)) {
                return true;
            }
        }
        return false;
    }
    public boolean ricercaParolaInMatriceTastiera() {
        int numRows = matrice.length;
        int numCols = matrice[0].length;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la parola: ");
        String inputString = scanner.nextLine();
        System.out.println("Hai inserito: " + inputString);

        boolean esiste = ricercaParolaInDizionario(inputString);
        if (esiste == false) {
            return false;
        }

        int wordLength = inputString.length();

        // Convert the word to a char array for easy character comparison
        char[] wordChars = inputString.toCharArray();

        // Iterate through the matrix rows
        for (int row = 0; row < numRows; row++) {
            // Iterate through the matrix columns
            for (int col = 0; col < numCols; col++) {
                // Check for matches in all eight directions
                for (int dirRow = -1; dirRow <= 1; dirRow++) {
                    for (int dirCol = -1; dirCol <= 1; dirCol++) {
                        // Skip the current cell (0,0) as it corresponds to the current word character
                        if (dirRow == 0 && dirCol == 0) {
                            continue;
                        }

                        // Start matching the word characters from the current cell (row, col)
                        int currentRow = row;
                        int currentCol = col;
                        int charIndex = 0;
                        boolean match = true;

                        // Continue matching while within the matrix boundaries
                        while (currentRow >= 0 && currentRow < numRows && currentCol >= 0 && currentCol < numCols &&
                                charIndex < wordLength && match) {
                            // Check if the current word character matches the current matrix cell
                            if (matrice[currentRow][currentCol] != wordChars[charIndex]) {
                                match = false;
                                break;
                            }

                            // Move to the next cell in the current direction
                            currentRow += dirRow;
                            currentCol += dirCol;
                            charIndex++;
                        }

                        // If all characters of the word match in the current direction, return true
                        if (match && charIndex == wordLength) {
                            return true;
                        }
                    }
                }
            }
        }

        return false; // Word not found in the matrix
        /*
        Boolean[] lettereTrov;
        char[][] lettereVicine = new char[3][3];
        int cont = 0;
        ////////////////////////////////////////////////////////

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisci la parola: ");
            String inputString = scanner.nextLine();
            System.out.println("Hai inserito: " + inputString);

            lettereTrov = new Boolean[inputString.length()];
            Arrays.fill(lettereTrov, Boolean.FALSE);

            for (int i = 0; i < inputString.length(); i++) {
                if (i > 0) {
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            if (lettereVicine[l][m] != '\u0000') {
                                if (lettereVicine[l][m] == inputString.charAt(i)) {
                                    lettereTrov[i] = true;
                                }
                            }
                        }
                    }
                    if (lettereTrov[i] == false) {
                        break;
                    }
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            lettereVicine[l][m] = '\u0000'; // Assigning null character to each element
                        }
                    }
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            if (lettereVicine[l][m] == '\u0000') {
                                // sos
                            }
                        }
                    }
                }
                for (int j = 0; j < matrice.length; j++) {
                    for (int k = 0; k < matrice.length; k++) {
                        if (inputString.charAt(i) == matrice[j][k]) {
                            int y = j - 1;
                            int x = k - 1;
                            for (int l = 0; l < 3; l++) {
                                x = k - 1;
                                for (int m = 0; m < 3; m++) {
                                    if (isValidIndex(matrice, y, x)) {
                                        if (l == 1 && m == 1) {
                                            //niente
                                        } else {
                                            lettereVicine[l][m] = matrice[y][x];
                                        }
                                    }
                                    x++;
                                }
                                y++;
                            }
                            lettereTrov[i] = true;
                            //System.out.println("Parola Trovata");
                            break;
                        }
                    }
                    if (lettereTrov[i] == true) {
                        break;
                    }
                }
                if (!isIndexOutOfRange((i+1), inputString.length())) {
                }
            }
            if (!areAllTrue(lettereTrov)) {
                System.out.println("Parola non Trovata");
            }
            scanner.close();
        } while (!areAllTrue(lettereTrov));
        */
    }
}