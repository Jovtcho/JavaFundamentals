package p01Logger.mediator;

import p01Logger.models.Attacker;
import p01Logger.models.Target;
import p01Logger.observer.ObservableTarget;

public interface AttackGroup {
    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();

}
