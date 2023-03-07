package pp;

import model.Matrice;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //GuiMenu menu = new GuiMenu("Il Paroliere - Menu");
        //menu.setVisible(true);

        GuiMenu2 menu = new GuiMenu2();
        menu.setContentPane(menu.getPanel());
        menu.setTitle("Il Paroliere - Menu");
        menu.setSize(400,200);
        menu.setVisible(true);

        Matrice griglia = new Matrice();
        griglia.caricaMatrice();
        griglia.visualMatrice();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}