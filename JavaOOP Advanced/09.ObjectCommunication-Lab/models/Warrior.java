package p01Logger.models;

import p01Logger.enumerations.LogType;
import p01Logger.logger.Handler;
import p01Logger.observer.ObservableTarget;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(ObservableTarget target, int dmg, Handler handler) {
        handler.handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
