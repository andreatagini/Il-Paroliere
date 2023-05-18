package db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;


public class GUI_Scoreboard extends JFrame {
    private JPanel panel1;

    public GUI_Scoreboard() {
        setTitle("CLASSIFICA GIOCATORE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(400, 300));
        setLocationRelativeTo(null);

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome Giocatore");
        model.addColumn("Punteggio");
        table.setFont(new Font("Arial", Font.BOLD, 15));

        try {
            String query = "SELECT nomeGiocatore, punteggio FROM partita ORDER BY punteggio DESC";
            DBconnection conn = new DBconnection();
            ResultSet rs = conn.querySelect(query);

            while (rs.next()) {
                String nomeGiocatore = rs.getString("nomeGiocatore");
                int punteggio = rs.getInt("punteggio");
                model.addRow(new Object[]{nomeGiocatore, punteggio});
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.setModel(model);


        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI_Scoreboard frame = new GUI_Scoreboard();
            frame.setVisible(true);
        });
    }
}
