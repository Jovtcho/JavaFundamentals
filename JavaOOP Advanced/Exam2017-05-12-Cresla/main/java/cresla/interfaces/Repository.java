package cresla.interfaces;

import java.util.Map;

public interface Repository {
    void addReactor(Reactor reactor);

    Reactor getReactorById(int reactorId);

    Map<Integer, Reactor> getAllReactors();

    void addModule(Module module);

    Module getModuleById(int moduleId);

    Map<Integer, Module> getAllModules();
}
