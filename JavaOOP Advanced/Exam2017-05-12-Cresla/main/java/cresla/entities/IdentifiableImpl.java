package cresla.entities;

import cresla.interfaces.Identifiable;

public class IdentifiableImpl implements Identifiable {
    private static final int INITIAL_ID_VALUE = 1;
    private int id;

    public IdentifiableImpl() {
        this.id = INITIAL_ID_VALUE;
    }

    @Override
    public int getId() {
        return id++;
    }
}
