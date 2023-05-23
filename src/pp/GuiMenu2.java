package pp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GuiMenu2 extends JFrame{
    private JPanel panelMenu;
    private JButton btnPlay;
    private JButton btnStanding;
    private JLabel labelName;
    private JLabel menuLabel;
    private JTextField textInputName;
    private JLabel titoloLabel;


    public GuiMenu2() {

        // Configurazione del JFrame
        setTitle("Il Paroliere");
        setContentPane(panelMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);

        // Crea un bordo personalizzato
        Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
        btnPlay.setBorder(border);
        btnPlay.setBackground(Color.BLUE);

        btnStanding.setBorder(border);
        btnStanding.setBackground(Color.BLUE);

        try {
            BufferedImage originalImage = ImageIO.read(getClass().getResourceAsStream("ilParoliere.png"));
            BufferedImage resizedImage = resizeImage(originalImage, titoloLabel.getWidth(), titoloLabel.getHeight());
            titoloLabel.setIcon(new ImageIcon(resizedImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Le actionListener
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGuiGame();
            }
        });

        btnStanding.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGuiStand();
            }
        });
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    private void newGuiGame() {
        //prendo il nome del giocatore
        String nomeGiocatore = textInputName.getText();
        GuiGame schermataGioco = new GuiGame(this, nomeGiocatore);
    }

    private void newGuiStand() {
        GUI_Scoreboard guiScoreboard = new GUI_Scoreboard(GuiMenu2.this);
        guiScoreboard.setVisible(true);
    }

    public JPanel getPanel() {
        return panelMenu;
    }
}