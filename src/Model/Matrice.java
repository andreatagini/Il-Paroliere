package Model;

import db.DBquery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Matrice implements ActionListener {

    //ATTRIBUTI
    private char[][] matrice;
    private ArrayList<String> paroleRipetute;
    private ArrayList<String> paroleComuni;
    DBquery connect = null;

    //COSTRUTTORE
    public Matrice() {
        this.matrice = new char[10][10];
        paroleRipetute = new ArrayList<>();
        paroleComuni = new ArrayList<>();
        connect = new DBquery();
    }

    //GETTER AND SETTER
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

    //METODI
    public void caricaParoleComuni() throws SQLException {
        ArrayList<String> diz = connect.getFullDiz();
        for (int i = 0; i < diz.size(); i++) {
            if (diz.get(i).length() < 7) {
                paroleComuni.add(diz.get(i));
            }
        }
    }
    public void caricaMatrice() {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                this.matrice[i][j] = alphabet.charAt(r.nextInt(alphabet.length()));
            }
        }
        inserisciParoleComuniInMatrice();
    }
    public void inserisciParoleComuniInMatrice() {
        try {
            caricaParoleComuni();
        } catch (SQLException ex) {
            throw new RuntimeException(ex + " Errore in caricaParoleComuni");
        }

        for (int j = 0; j < 10; j++) {
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
        }
    }
    public int isDentroRange(int nCasX, int nCasY, String comune) {
        boolean inRange = false;
        int nCas2;
        do {
            //numero random per la direzione in cui verra inserita
            Random r2 = new Random();
            nCas2 = r2.nextInt(8) + 1;//numero compreso tra 1 e 8
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
                if (0 < nCasX - comune.length() && nCasX - comune.length() < matrice[0].length) {
                    if (nCasY + comune.length() < matrice.length) {
                        inRange = true;
                    }
                }
            }
            if (nCas2 == 5) {
                if (0 < nCasX - comune.length() && nCasX - comune.length() < matrice[0].length) {
                    inRange = true;
                }
            }
            if (nCas2 == 6) {
                if (0 < nCasX - comune.length() && nCasX - comune.length() < matrice[0].length) {
                    if (0 < nCasY - comune.length() && nCasY - comune.length() < matrice.length) {
                        inRange = true;
                    }
                }
            }
            if (nCas2 == 7) {
                if (0 < nCasY - comune.length() && nCasY - comune.length() < matrice.length) {
                    inRange = true;
                }
            }
            if (nCas2 == 8) {
                if (nCasX + comune.length() < matrice[0].length) {
                    if (0 < nCasY - comune.length() && nCasY - comune.length() < matrice.length) {
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
    //ricercaParolaInMatriceButton
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getText();
        System.out.println("Hai cliccato il bottone: " + buttonName);
    }
    public static boolean isIndexOutOfRange(int index, int arrayLength) {
        return index < 0 || index >= arrayLength;
    }
    public boolean ricercaParolaInDizionario(String parola) throws SQLException {
        boolean trovato = connect.getParolaDb(parola);
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
    public boolean ricercaParolaInMatriceTastiera(String parola) throws SQLException {
        int rows = matrice.length;
        int cols = matrice[0].length;

        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la parola: ");
        String inputString = scanner.nextLine();
        System.out.println("Hai inserito: " + inputString);*/

        boolean esiste = ricercaParolaInDizionario(parola);
        if (esiste == false) {
            return false;
        }

        // Scorrere ogni cella della matrice
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (ricercaParola(matrice, parola, i, j, 0)) {
                    if (verificaParolaRipetuta(parola) == false) {
                        paroleRipetute.add(parola);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }
    private boolean ricercaParola(char[][] matrix, String word, int i, int j, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Verifica se la posizione corrente è valida e corrisponde alla lettera della parola
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] != word.charAt(k)) {
            return false;
        }

        // Se l'intera parola è stata trovata, restituisci true
        if (k == word.length() - 1) {
            return true;
        }

        // Controlla ricorsivamente le celle adiacenti nella matrice
        char temp = matrix[i][j];
        matrix[i][j] = '#';  // Segna la cella come visitata

        boolean found = ricercaParola(matrix, word, i - 1, j, k + 1) ||
                ricercaParola(matrix, word, i + 1, j, k + 1) ||
                ricercaParola(matrix, word, i, j - 1, k + 1) ||
                ricercaParola(matrix, word, i, j + 1, k + 1);

        matrix[i][j] = temp;  // Ripristina il carattere originale

        return found;
    }
}