package p01Logger.commands.groupCommands;

import p01Logger.commands.Command;
import p01Logger.mediator.AttackGroup;
import p01Logger.models.Target;
import p01Logger.observer.ObservableTarget;

import java.util.List;

public class GroupTargetCommand implements Command {
    private AttackGroup group;
    private ObservableTarget target;

    public GroupTargetCommand(AttackGroup group, ObservableTarget target) {
        this.group = group;
        this.target = target;
    }

    @Override
    public void execute() {
        this.group.groupTarget(this.target);
    }
}
