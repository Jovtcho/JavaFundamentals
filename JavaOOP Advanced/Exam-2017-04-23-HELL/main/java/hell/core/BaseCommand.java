package hell.core;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Inventory;
import hell.repository.Repository;

public abstract class BaseCommand implements Executable {

    @ItemCollection
    private String[] params;
    @ItemCollection
    private Repository heroRepository;

    protected BaseCommand() {
    }

    public String[] getParams() {
        return this.params;
    }

    public Repository getRepository() {
        return this.heroRepository;
    }
}
