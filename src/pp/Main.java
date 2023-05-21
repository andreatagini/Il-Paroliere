package pp;

import Model.Matrice;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        GuiMenu2 menu = new GuiMenu2();
        menu.setContentPane(menu.getPanel());
        menu.setTitle("Il Paroliere - Menu");
        menu.setSize(400,200);
        menu.setVisible(true);

        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}