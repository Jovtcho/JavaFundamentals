package p01Logger.commands.individualCommands;

import p01Logger.commands.Command;
import p01Logger.models.Attacker;
import p01Logger.models.Target;
import p01Logger.observer.ObservableTarget;

public class TargetCommand implements Command {
    private Attacker attacker;
    private ObservableTarget target;

    public TargetCommand(Attacker attacker, ObservableTarget target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
