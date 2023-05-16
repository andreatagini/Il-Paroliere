package db;

public class DBquery {

    public boolean getInsert(String nomeGiocatore, int punteggio) {
        DBconnection connessione1 = new DBconnection();
        String query = "INSERT INTO partita (nomeGiocatore, punteggio) VALUES ('"+nomeGiocatore+"', '"+punteggio+"')";
        boolean success = connessione1.queryInsert(query);

        return success;
    }

    public static void main(String[] args) {
        DBquery sql = new DBquery();
        sql.getInsert("Raffo", 1024);
    }
}
