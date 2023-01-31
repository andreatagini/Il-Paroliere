package pp;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.swing.event.*;
import java.awt.event.*;
public class GuiMenu extends JFrame implements ActionListener {

    public GuiMenu(String titolo) {
        this.setSize(1000,600);
        this.setTitle(titolo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // gestore chiusura finestra
        this.setLayout(null);
    }

    public void actionPerformed(ActionEvent e)
    {

    }

}
