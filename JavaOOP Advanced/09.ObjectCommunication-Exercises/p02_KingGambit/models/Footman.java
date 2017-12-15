package p02_KingGambit.models;

import p02_KingGambit.observer.Observer;

import static p02_KingGambit.Constants.FOOTMAN_PANICK_MESSAGE;
import static p02_KingGambit.Constants.INITIAL_KILL_COUNTER;

public class Footman extends BasePerson implements Observer {
    private int killCounter;

    public Footman(String name) {
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
        return this.killCounter == 2;

    }

    @Override
    public String toString() {
        return String.format(FOOTMAN_PANICK_MESSAGE, this.getName()).trim();
    }
}
