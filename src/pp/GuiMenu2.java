package pp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu2 extends JFrame{
    private JPanel panelMenu;
    private JButton btnPlay;
    private JButton btnStanding;


    public GuiMenu2() {
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGuiGame();
            }
        });
    }

    private void newGuiGame() {
        GuiGame schermataGioco = new GuiGame();
        schermataGioco.setContentPane(schermataGioco.getPanel());
        schermataGioco.setTitle("Il Paroliere - Gioca!");
        schermataGioco.setSize(1000,800);
        schermataGioco.setVisible(true);
        schermataGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(false);
    }

    public JPanel getPanel() {
        return panelMenu;
    }
}
