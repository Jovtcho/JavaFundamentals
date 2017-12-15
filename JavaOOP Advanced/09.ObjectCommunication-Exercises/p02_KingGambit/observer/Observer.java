package p02_KingGambit.observer;

import p02_KingGambit.models.Person;

public interface Observer extends Person {
    void update();

    boolean setKillCounter();
}
