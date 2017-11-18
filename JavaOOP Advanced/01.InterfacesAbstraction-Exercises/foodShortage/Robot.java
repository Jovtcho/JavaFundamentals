package foodShortage;

public class Robot extends Inhabitant implements Idable {
    private String model;

    Robot(String model, String id) {
        super(id);
        this.setModel(model);
    }

    private void setModel(String model) {
        this.model = model;
    }
}
