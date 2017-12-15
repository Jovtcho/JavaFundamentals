package p02_KingGambit.models;

import p02_KingGambit.observer.Observer;

import java.util.LinkedHashMap;
import java.util.Map;

public class DeathController {
    private Kingable king;

    public DeathController(Kingable king) {
        this.king = king;
    }

    public void executeKill(Observer observerForCheck) {
        boolean isKilled = observerForCheck.setKillCounter();
        if (isKilled) {
            this.king.unregister(observerForCheck.getName());
        }

    }
}
