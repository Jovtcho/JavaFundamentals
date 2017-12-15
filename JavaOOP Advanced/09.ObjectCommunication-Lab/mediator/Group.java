package p01Logger.mediator;

import p01Logger.models.Attacker;
import p01Logger.models.Target;
import p01Logger.observer.ObservableTarget;

import java.util.LinkedList;
import java.util.List;

public class Group implements AttackGroup {
    private List<Attacker> attackers;

    public Group() {
        this.attackers = new LinkedList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        for (Attacker attacker : attackers) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : attackers) {
            attacker.attack();
        }
    }
}
