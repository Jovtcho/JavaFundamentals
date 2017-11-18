package mooD3;

public class Demon extends BaseGameObject implements GameObject {
    private double energy;

    public Demon(String username, int level, double energy) {
        super(username, level);
        this.energy = energy;
    }

    @Override
    public String setHashedPassword() {
        //username length * 217
        return String.valueOf(super.getUsername().length() * 217);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("%s %s", super.toString(), this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append(String.valueOf(this.energy * super.getLevel()));
        return sb.toString();
    }
}
