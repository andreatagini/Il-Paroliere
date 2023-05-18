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
    private ArrayList<String> words;
    private ArrayList<String> paroleRipetute;
    private ArrayList<String> paroleComuni;

    //costruttore
    public Matrice() {
        this.matrice = new char[10][10];
        words = new ArrayList<>();
        paroleRipetute = new ArrayList<>();
        paroleComuni = new ArrayList<>();
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
    public ArrayList<String> getParoleRipetute() {
        return paroleRipetute;
    }
    public void setParoleRipetute(ArrayList<String> paroleRipetute) {
        this.paroleRipetute = paroleRipetute;
    }
    public ArrayList<String> getParoleComuni() {
        return paroleComuni;
    }
    public void setParoleComuni(ArrayList<String> paroleComuni) {
        this.paroleComuni = paroleComuni;
    }

    public void caricaMatrice() {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                this.matrice[i][j] = alphabet.charAt(r.nextInt(alphabet.length()));
            }
        }
        matrice[0][0] = 'c';
        matrice[0][1] = 'i';
        matrice[0][2] = 'a';
        matrice[0][3] = 'o';
        /*for (int j = 0; j < 7; j++) {
            //prendo string casuale dall'array parole comuni
            Random r1 = new Random();
            int nCas1 = r1.nextInt(getParoleComuni().size());
            String comune = getParoleComuni().get(nCas1);
            System.out.println(comune);
            //numeri random per la posizione della matrice
            Random rx = new Random();
            int nCasX = rx.nextInt(10);//numero compreso tra 0 e 9
            Random ry = new Random();
            int nCasY = ry.nextInt(10);
            //numero random per la direzione in cui verra inserita
            int nCas2 = isDentroRange(nCasX, nCasY, comune);
            //inserimento di parole comuni nella matrice
            matrice[nCasY][nCasX] = comune.charAt(0);
            for (int i = 1; i < comune.length(); i++) {
                if (nCas2 == 1) {
                    matrice[nCasY][nCasX+i] = comune.charAt(i);
                }
                if (nCas2 == 2) {
                    matrice[nCasY+i][nCasX+i] = comune.charAt(i);
                }
                if (nCas2 == 3) {
                    matrice[nCasY+i][nCasX] = comune.charAt(i);
                }
                if (nCas2 == 4) {
                    matrice[nCasY+i][nCasX-i] = comune.charAt(i);
                }
                if (nCas2 == 5) {
                    matrice[nCasY][nCasX-i] = comune.charAt(i);
                }
                if (nCas2 == 6) {
                    matrice[nCasY-i][nCasX-i] = comune.charAt(i);
                }
                if (nCas2 == 7) {
                    matrice[nCasY-i][nCasX] = comune.charAt(i);
                }
                if (nCas2 == 8) {
                    matrice[nCasY-i][nCasX+i] = comune.charAt(i);
                }
            }
        }*/
    }
    public int isDentroRange(int nCasX, int nCasY, String comune) {
        boolean inRange = false;
        int nCas2;
        do {
            //numero random per la direzione in cui verra inserita
            Random r2 = new Random();
            nCas2 = r2.nextInt(8) + 1;//numero compreso tra 1 e 8
            System.out.print(nCas2);
            System.out.println("x: "+nCasX);
            System.out.println("y: "+nCasY);
            if (nCas2 == 1) {
                if (nCasX + comune.length() < matrice[0].length) {
                    inRange = true;
                }
            }
            if (nCas2 == 2) {
                if (nCasX + comune.length() < matrice[0].length) {
                    if (nCasY + comune.length() < matrice.length) {
                        inRange = true;
                    }
                }
            }
            if (nCas2 == 3) {
                if (nCasY + comune.length() < matrice.length) {
                    inRange = true;
                }
            }
            if (nCas2 == 4) {
                if (nCasX + comune.length() < matrice[0].length) {
                    if (nCasY + comune.length() < matrice.length) {
                        inRange = true;
                    }
                }
            }
            if (nCas2 == 5) {
                if (nCasX + comune.length() < matrice[0].length) {
                    inRange = true;
                }
            }
            if (nCas2 == 6) {
                if (nCasX + comune.length() < matrice[0].length) {
                    if (nCasY + comune.length() < matrice.length) {
                        inRange = true;
                    }
                }
            }
            if (nCas2 == 7) {
                if (nCasY + comune.length() < matrice.length) {
                    inRange = true;
                }
            }
            if (nCas2 == 8) {
                if (nCasX + comune.length() < matrice[0].length) {
                    if (nCasY + comune.length() < matrice.length) {
                        inRange = true;
                    }
                }
            }
        } while (inRange == false);
        return nCas2;
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
            //inserimento di parole comuni in un arraylist
            if (word.length() <= 6) {
                paroleComuni.add(word);
            }
            words.add(word);
        }

        scanner.close();
    }

    //ricercaParolaInMatriceButton
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getText();
        System.out.println("Hai cliccato il bottone: " + buttonName);
    }
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
    public static boolean cercaParola(char[][] matrice, String parola) {
        int m = matrice.length;
        int n = matrice[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (trovaParola(matrice, parola, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
    private static boolean trovaParola(char[][] matrice, String parola, int riga, int colonna, int indice) {
        if (indice == parola.length()) {
            return true;
        }

        if (riga < 0 || colonna < 0 || riga >= matrice.length || colonna >= matrice[0].length) {
            return false;
        }

        if (matrice[riga][colonna] != parola.charAt(indice)) {
            return false;
        }

        char temp = matrice[riga][colonna];
        matrice[riga][colonna] = ' ';

        boolean trovato = trovaParola(matrice, parola, riga + 1, colonna, indice + 1)
                || trovaParola(matrice, parola, riga - 1, colonna, indice + 1)
                || trovaParola(matrice, parola, riga, colonna + 1, indice + 1)
                || trovaParola(matrice, parola, riga, colonna - 1, indice + 1);

        matrice[riga][colonna] = temp;

        return trovato;
    }
    public boolean verificaParolaRipetuta(String p) {
        boolean ripetuto = false;
        for (int i = 0; i < paroleRipetute.size(); i++) {
            if(paroleRipetute.get(i).equals(p)) {
                ripetuto = true;
            }
        }
        return ripetuto;
    }
    public boolean ricercaParolaInMatriceTastiera(String parola) {
        int numRows = matrice.length;
        int numCols = matrice[0].length;

        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la parola: ");
        String inputString = scanner.nextLine();
        System.out.println("Hai inserito: " + inputString);*/

        boolean esiste = ricercaParolaInDizionario(parola);
        if (esiste == false) {
            return false;
        }

        int wordLength = parola.length();

        // Convert the word to a char array for easy character comparison
        char[] wordChars = parola.toCharArray();

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
                            if (verificaParolaRipetuta(parola) == false) {
                                paroleRipetute.add(parola);
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return false; // Word not found in the matrix
    }
}