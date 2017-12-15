package p02_KingGambit;

import p02_KingGambit.models.*;
import p02_KingGambit.observer.Observer;
import p02_KingGambit.observer.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String kingName = br.readLine();
        Kingable king = new King(kingName);

        String[] royalGuardNames = br.readLine().split("\\s+");
        for (String royalGuardName : royalGuardNames) {
            Observer observer = new RoyalGuard(royalGuardName);
            king.register(observer);
        }

        String[] footmanNames = br.readLine().split("\\s+");
        for (String footmanName : footmanNames) {
            Observer observer = new Footman(footmanName);
            king.register(observer);
        }

        DeathController deathController = new DeathController(king);

        while (true) {
            String input = br.readLine();
            if ("End".equalsIgnoreCase(input)) {
                break;
            }

            String[] commands = input.split("\\s+");


            switch (commands[0].toLowerCase()) {
                case "kill":
                    //deathController.setObservers(king.getObservers());
                    Observer observer = king.getObserver(commands[1]);
                    if (observer != null) {
                        deathController.executeKill(observer);
                    }
                    //king.unregister(commands[1]);
                    break;
                case "attack":
                    king.takeAttack();
                    break;
            }
        }
    }
}
