package mooD3;

public class Archangel extends BaseGameObject implements GameObject {
    private int mana;

    public Archangel(String username, int level, int mana) {
        super(username, level);
        this.mana = mana;
    }


    @Override
    public String setHashedPassword() {
        //(username’s characters in reversed order) + (username’s characters' length * 21)
        return String.valueOf(new StringBuilder(super.getUsername()).reverse().toString()
                + (super.getUsername().length() * 21));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("%s %s", super.toString(), this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append(String.valueOf(this.mana * super.getLevel()));
        return sb.toString();
    }
}
