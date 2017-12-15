package p01Logger.models;

import p01Logger.enumerations.LogType;
import p01Logger.logger.Handler;
import p01Logger.observer.ObservableTarget;
import p01Logger.observer.Observer;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "p01Logger.models.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";
    private static final String REWARD_RECEIVING_MESSAGE = "%s received %d reward";

    private String id;
    private int dmg;
    private ObservableTarget target;
    private Handler handler;

    public AbstractHero(String id, int dmg, Handler handler) {
        this.id = id;
        this.dmg = dmg;
        this.handler = handler;
    }

    public void setTarget(ObservableTarget target) {
        if (target == null) {
            this.handler.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            this.target.register(this);
            this.handler.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    public final void attack() {
        if (this.target == null) {
            this.handler.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.handler.handle(LogType.ERROR, String.format(TARGET_DEAD_MESSAGE, target));

        } else {
            this.executeClassSpecificAttack(this.target, this.dmg, this.handler);

        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    public void update(int reward) {
        this.handler.handle(LogType.EVENT, String.format(REWARD_RECEIVING_MESSAGE, this, reward));
    }

    protected abstract void executeClassSpecificAttack(ObservableTarget target, int dmg, Handler handler);
}
