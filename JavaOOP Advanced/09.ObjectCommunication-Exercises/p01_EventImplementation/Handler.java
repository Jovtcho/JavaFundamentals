package p01_EventImplementation;

public class Handler implements NameChangeListener {
    private static final String DISPATCHER_NAME_CHANGED = "Dispatcher's name changed to %s." + System.lineSeparator();

    @Override
    public void handleChangedName(NameChange nameChange) {
        System.out.printf(DISPATCHER_NAME_CHANGED, nameChange);
    }
}
