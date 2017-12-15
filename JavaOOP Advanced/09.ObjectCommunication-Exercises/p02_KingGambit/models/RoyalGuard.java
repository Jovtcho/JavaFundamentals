package p02_KingGambit.models;

import p02_KingGambit.observer.Observer;

import static p02_KingGambit.Constants.INITIAL_KILL_COUNTER;
import static p02_KingGambit.Constants.ROYALGUARD_DEFEND_MESSAGE;

public class RoyalGuard extends BasePerson implements Observer {
    private int killCounter;

    public RoyalGuard(String name) {
        super(name);
        this.killCounter = INITIAL_KILL_COUNTER;
    }

    @Override
    public void update() {
        System.out.println(this.toString());
    }

    @Override
    public boolean setKillCounter() {
        this.killCounter++;
        return this.killCounter == 3;
    }

    @Override
    public String toString() {
        return String.format(ROYALGUARD_DEFEND_MESSAGE, this.getName()).trim();
    }
}
