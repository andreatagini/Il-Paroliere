package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Matrice {
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
    }
}
