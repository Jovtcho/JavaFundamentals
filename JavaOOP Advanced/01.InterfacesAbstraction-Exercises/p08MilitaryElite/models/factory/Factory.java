package p08MilitaryElite.models.factory;

import p08MilitaryElite.models.implementations.*;

public final class Factory {
    public static PrivateImpl createPrivate(int id, String firstName, String lastName, double salary) {
        return new PrivateImpl(id, firstName, lastName, salary);
    }

    public static LeutenantGeneralImpl createLeutenantGeneral(int id, String firstName, String lastName, double salary) {
        return new LeutenantGeneralImpl(id, firstName, lastName, salary);
    }

    public static EngineerImpl createEngineer(int id, String firstName, String lastName, double salary, String corpus) {
        return new EngineerImpl(id, firstName, lastName, salary, corpus);
    }

    public static CommandoImpl createCommando(int id, String firstName, String lastName, double salary, String corpus) {
        return new CommandoImpl(id, firstName, lastName, salary, corpus);
    }

    public static SpyImpl createSpy(int id, String firstName, String lastName, String codeNumber) {
        return new SpyImpl(id, firstName, lastName, codeNumber);
    }
}
