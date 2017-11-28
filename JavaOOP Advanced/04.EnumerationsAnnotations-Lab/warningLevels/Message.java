package warningLevels;

public class Message {
    private Importance importance;
    private String description;

    public Message(Importance importance, String description) {
        this.importance = importance;
        this.description = description;
    }

    public Importance getImportance() {
        return this.importance;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.importance, this.description);
    }
}
