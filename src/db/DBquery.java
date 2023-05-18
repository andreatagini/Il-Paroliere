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

    public boolean getParolaDb(String parola) throws SQLException {
        boolean check=false;
        String parolaTrovata = "";

        DBconnection connessione1 = new DBconnection();
        String query = "SELECT parola FROM parole WHERE parola = '"+parola+"'";
        ResultSet ris = connessione1.querySelect(query);
        if(ris.next()){
            parolaTrovata = ris.getString("parola");
            if(parolaTrovata!=null){
                check = true;
            }
        }

        return check;
    }
    public DBquery(){

    }

    public static void main(String[] args) throws SQLException {
        DBquery sql = new DBquery();

        //sql.getInsert("Raffo", 102224);
        System.out.println(sql.getParolaDb("io"));



    }
}
