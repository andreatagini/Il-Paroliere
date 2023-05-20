package pp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import db.DBquery;

public class GuiStop extends JFrame {
    private JPanel panelStop;
    private JTextField textName;
    private JTextField textPoint;
    private JButton btnSave;

    public GuiStop (GuiMenu2 guimenu, String nomeGiocatore, int point) {
        textName.setText(nomeGiocatore);
        textPoint.setText(Integer.toString(point));

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //salvo sul database la partita
                DBquery query = new DBquery();
                query.getInsert(nomeGiocatore, point);

                //apro il menu
                guimenu.setVisible(true);
                dispose();
            }
        });
    }

    public JPanel getPanel() {
        return panelStop;
    }
}
