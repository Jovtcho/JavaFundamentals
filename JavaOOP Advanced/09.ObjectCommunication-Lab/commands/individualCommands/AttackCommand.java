package p01Logger.commands.individualCommands;

import p01Logger.commands.Command;
import p01Logger.models.Attacker;

public class AttackCommand implements Command {
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}
