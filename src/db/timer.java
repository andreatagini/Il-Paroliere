package db;

import java.util.*;
public class timer {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            public void run() {
                DBquery sql = new DBquery();
                sql.getInsert("Tagio", 1000);
                timer.cancel();
            }
        };

        timer.schedule(task, 3000);
    }
}
