package pp;

import model.Matrice;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GuiMenu2 menu = new GuiMenu2();
        menu.setContentPane(menu.getPanel());
        menu.setTitle("Il Paroliere - Menu");
        menu.setSize(400,200);
        menu.setVisible(true);

        Matrice griglia = new Matrice();
        griglia.caricaMatrice();
        griglia.visualMatrice();
        griglia.caricaFileToArray();
        boolean find = griglia.ricercaParolaInMatriceTastiera();
        if (find == true) {
            System.out.println("Parola trovata");
        } else {
            System.out.println("Parola non trovata");
        }
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}