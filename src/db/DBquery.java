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

    public ArrayList getFullDiz() throws SQLException {
        ArrayList<String> dizionario = new ArrayList<>();

        DBconnection connessione1 = new DBconnection();
        String query = "SELECT * FROM parole WHERE parola LIKE '______' OR parola LIKE '_____' OR parola LIKE '____' OR parola LIKE '___' OR parola LIKE '__' OR parola LIKE '_';";
        System.out.println(0);
        ResultSet fullDiz = connessione1.querySelect(query);
        System.out.println(1);

        while (fullDiz.next()){
            dizionario.add(fullDiz.getString("parola"));
        }

        return dizionario;
    }

    public static void main(String[] args) throws SQLException {
        DBquery sql = new DBquery();

        //sql.getInsert("Raffo", 102224);
        System.out.println(sql.getParolaDb("io"));



    }
}
