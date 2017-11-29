package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public abstract class Command implements Executable {
    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    Command() {
    }

    String[] getData() {
        return this.data;
    }

    Repository getRepository() {
        return this.repository;
    }

    UnitFactory getUnitFactory() {
        return this.unitFactory;
    }
}
