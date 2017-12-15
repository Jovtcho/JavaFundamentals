package p02_KingGambit.observer;

import p02_KingGambit.models.Person;

public interface Subject extends Person{
    void register(Observer observer);

    void unregister(String observerName);

    void notifyObservers();


}
