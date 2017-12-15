package cresla.factory;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.Reactor;

public final class ReactorFactory {
    private ReactorFactory() {
    }

    public static Reactor createReactor(String reactorType, int id, int additionalParameter, int moduleCapacity) {
        Reactor reactor = null;
        ModuleContainer moduleContainer = new ModuleContainer(moduleCapacity);

        switch (reactorType) {
            case "Cryo":
                return reactor = new CryoReactor(id, moduleContainer, additionalParameter);
            case "Heat":
                return reactor = new HeatReactor(id, moduleContainer, additionalParameter);
            default:
                return null;
        }
    }
}
