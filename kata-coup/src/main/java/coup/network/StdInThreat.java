package coup.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInThreat extends Thread {

    private String stdIn = "";

    @Override
    public void run() {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String msg;

        try {

            while ((msg = stdin.readLine()) != null) {
                System.out.println("Captured in the client: " + msg);
                stdIn = "To send to the server: " + msg;
            }

            System.out.println("Aborted.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String fromThread() {
        return stdIn;
    }

}