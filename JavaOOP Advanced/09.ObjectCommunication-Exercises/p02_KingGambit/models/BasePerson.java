package p02_KingGambit.models;

import p02_KingGambit.observer.Observer;

public abstract class BasePerson implements Person  {
    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //public abstract void update();
}
