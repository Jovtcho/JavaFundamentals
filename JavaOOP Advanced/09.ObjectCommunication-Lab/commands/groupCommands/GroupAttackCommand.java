package p01Logger.commands.groupCommands;

import p01Logger.commands.Command;
import p01Logger.mediator.AttackGroup;

public class GroupAttackCommand implements Command {
    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        this.group.groupAttack();
    }
}
