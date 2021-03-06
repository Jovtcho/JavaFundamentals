package p01_EventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;

    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher(String name) {
        this.name = name;
        this.nameChangeListeners = new ArrayList<>();
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.remove(nameChangeListener);
    }

    public void fireNameChangeEvent(NameChange nameChange) {
        for (NameChangeListener nameChangeListener : nameChangeListeners) {
            nameChangeListener.handleChangedName(nameChange);
        }
    }
}
