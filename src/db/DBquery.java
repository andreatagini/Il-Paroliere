package db;
import java.util.*;
import java.sql.*;
public class DBquery {

    public boolean getInsert(String nomeGiocatore, int punteggio) {
        DBconnection connessione1 = new DBconnection();
        String query = "INSERT INTO partita (nomeGiocatore, punteggio) VALUES ('"+nomeGiocatore+"', '"+punteggio+"')";
        boolean success = connessione1.queryInsert(query);

        return success;
    }

    public ResultSet getSelect() {
        DBconnection connessione1 = new DBconnection();
        String query = "SELECT nomeGiocatore, punteggio FROM partita;";
        ResultSet anagrafica = connessione1.querySelect(query);

        return anagrafica;
    }

    public String getParolaDb(String parola) throws SQLException {
        DBconnection connessione1 = new DBconnection();
        String query = "SELECT parola FROM parole WHERE parola = '"+parola+"'";
        ResultSet ris = connessione1.querySelect(query);

        return ris.getString("parola");
    }

    public static void main(String[] args) {
        DBquery sql = new DBquery();
        sql.getInsert("Raffo", 102224);
    }
}
