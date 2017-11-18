package mooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split("\\s+\\|\\s+");
        String type = tokens[1];

        GameObject gameObject = null;
        switch (type) {
            case "Demon":
                gameObject = new Demon(tokens[0], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[2]));
                break;
            case "Archangel":
                gameObject = new Archangel(tokens[0], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[2]));
                break;
        }

        if (gameObject != null) {
            System.out.println(gameObject.toString());
        }
    }
}
