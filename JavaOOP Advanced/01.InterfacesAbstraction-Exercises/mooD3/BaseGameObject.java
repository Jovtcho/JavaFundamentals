package mooD3;

public abstract class BaseGameObject implements GameObject {
    private String username;
    private String hashedPassword;
    private int level;

    protected BaseGameObject(String username, int level) {
        this.username = username;
        this.hashedPassword = setHashedPassword();
        this.level = level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected int getLevel() {
        return this.level;
    }

    private String getHashedPassword() {
        return this.hashedPassword;
    }

    public abstract String setHashedPassword();

    @Override
    public String toString() {
        //""KoHaH"" | "1519" -> Demon
        return String.format("\"%s\" | \"%s\" ->", this.getUsername(), this.getHashedPassword());
    }
}
