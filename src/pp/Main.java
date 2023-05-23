package pp;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiMenu2 menu = new GuiMenu2();
            }
        });
    }
}