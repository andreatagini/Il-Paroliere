package pp;
import model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.swing.event.*;
import java.awt.event.*;

public class GuiMenu extends JFrame {
    public GuiMenu() {
        super("Esempio di JFrame con bottoni");

        JPanel panel = new JPanel();

        JButton button1 = new JButton("Bottone 1");
        JButton button2 = new JButton("Bottone 2");

        panel.add(button1);
        panel.add(button2);

        button1.addActionListener(new MyActionListener());
        button2.addActionListener(new MyActionListener());

        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
