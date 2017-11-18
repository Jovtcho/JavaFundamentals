package foodShortage;

public abstract class Inhabitant implements Idable {
    private String id;

    Inhabitant(String id) {
        this.setId(id);
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
