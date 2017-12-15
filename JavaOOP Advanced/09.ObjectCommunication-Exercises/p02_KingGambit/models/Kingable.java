package p02_KingGambit.models;

import p02_KingGambit.observer.Observer;
import p02_KingGambit.observer.Subject;

import java.util.Map;

public interface Kingable extends Subject {

    Observer getObserver(String observerName);

    void takeAttack();
}
