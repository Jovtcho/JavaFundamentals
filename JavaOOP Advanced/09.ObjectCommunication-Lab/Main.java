package p01Logger;

import p01Logger.commands.*;
import p01Logger.commands.groupCommands.GroupAttackCommand;
import p01Logger.commands.groupCommands.GroupTargetCommand;
import p01Logger.logger.CombatLogger;
import p01Logger.logger.ErrorLogger;
import p01Logger.logger.EventLogger;
import p01Logger.logger.Handler;
import p01Logger.mediator.AttackGroup;
import p01Logger.mediator.Group;
import p01Logger.models.Attacker;
import p01Logger.models.Dragon;
import p01Logger.models.Target;
import p01Logger.models.Warrior;
import p01Logger.observer.ObservableTarget;

public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();
        Handler errorLogger = new ErrorLogger();

        combatLogger.setSuccessor(eventLogger);
        eventLogger.setSuccessor(errorLogger);

        //Attacker warrior = new Warrior("Pesho", 100, combatLogger);
        Attacker warriorOne = new Warrior("Pesho", 100, combatLogger);
        Attacker warriorTwo = new Warrior("Smesho", 100, combatLogger);
        Attacker warriorThree = new Warrior("Pijo", 100, combatLogger);
        ObservableTarget dragon = new Dragon("Gosho", 100, 100, combatLogger);
        AttackGroup groupOne = new Group();
        groupOne.addMember(warriorOne);
        groupOne.addMember(warriorTwo);
        groupOne.addMember(warriorThree);

        //warrior.setTarget(dragon);
        //warrior.attack();

        Executor executor = new CommandExecutor();
        //Command targetCommand = new TargetCommand(warrior, dragon);
        //Command attackCommand = new AttackCommand(warrior);
        //executor.executeCommand(targetCommand);
        //executor.executeCommand(attackCommand);

        Command groupOneTarget = new GroupTargetCommand(groupOne, dragon);
        Command groupOneAttack = new GroupAttackCommand(groupOne);

        executor.executeCommand(groupOneTarget);
        executor.executeCommand(groupOneAttack);
    }
}
