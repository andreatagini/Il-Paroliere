package pp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu2 extends JFrame{
    private JPanel panelMenu;
    private JButton btnPlay;
    private JButton btnStanding;
    private JLabel labelInsName;
    private JTextField textInputName;


    public GuiMenu2() {
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

    private void newGuiGame() {
        //prendo il nome del giocatore
        String nomeGiocatore = textInputName.getText();
        GuiGame schermataGioco = new GuiGame(GuiMenu2.this, nomeGiocatore);
        schermataGioco.setContentPane(schermataGioco.getPanel());
        schermataGioco.setTitle("Il Paroliere - Gioca!");
        schermataGioco.setSize(1000,900);
        schermataGioco.setVisible(true);
        schermataGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(false);
    }

    private void newGuiStand() {
        GUI_Scoreboard guiScoreboard = new GUI_Scoreboard(GuiMenu2.this);
        guiScoreboard.setVisible(true);
    }

    public JPanel getPanel() {
        return panelMenu;
    }
}
