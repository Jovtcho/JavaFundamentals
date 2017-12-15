package p02_KingGambit.models;

import p02_KingGambit.observer.Observer;
import p02_KingGambit.observer.Subject;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static p02_KingGambit.Constants.KING_UNDER_ATTACK_MESSAGE;

public class King extends BasePerson implements Kingable {
    private Map<String, Observer> observers;

    public King(String name) {
        super(name);
        this.observers = new LinkedHashMap<>();
    }

    @Override
    public void register(Observer observer) {
        this.observers.put(observer.getName(), observer);
    }

    @Override
    public void unregister(String observerName) {
        if (this.observers.containsKey(observerName)) {
            this.observers.remove(observerName);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers.values()) {
            observer.update();
        }
    }

    @Override
    public Observer getObserver(String observerName) {
        if (this.observers.containsKey(observerName)) {
            return this.observers.get(observerName);
        }
        return null;
    }

    @Override
    public void takeAttack() {
        System.out.println(this.toString());
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return String.format(KING_UNDER_ATTACK_MESSAGE, this.getName().trim());
    }
}
