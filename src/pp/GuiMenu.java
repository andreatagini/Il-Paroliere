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
        this.setResizable(false);

        Container content = this.getContentPane();
        content.setLayout(new GridLayout(1, 3));

        content.add(new JButton("Button 1"));
        content.add(new JButton("Button 2"));
        content.add(new JButton("Button 3"));

        this.pack();
    }

    public void actionPerformed(ActionEvent e)
    {

    }

}
