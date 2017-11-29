package pr0304Barracks.Exceptions;

public class NotFoundElement extends IllegalArgumentException {
    private static final String NOT_FOUND_ELEMENT_EXCEPTION = "No such units in repository.";

    public NotFoundElement() {
        super(NOT_FOUND_ELEMENT_EXCEPTION);
    }

    public NotFoundElement(String message) {
        super(message);
    }
}
