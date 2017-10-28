package rawData;

public class Engine {
    private static final int DEFAULT_ENGINE_POWER = 250;
    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public boolean checkEnginePower(Engine engine) {
        return engine.getPower() > DEFAULT_ENGINE_POWER;
    }
}
