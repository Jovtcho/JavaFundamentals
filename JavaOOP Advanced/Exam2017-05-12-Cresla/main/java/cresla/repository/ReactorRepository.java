package cresla.repository;

import cresla.interfaces.Module;
import cresla.interfaces.Reactor;
import cresla.interfaces.Repository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReactorRepository implements Repository {
    private Map<Integer, Reactor> reactorRepository;
    private Map<Integer, Module> reactorModules;

    public ReactorRepository() {
        this.reactorRepository = new LinkedHashMap<>();
        this.reactorModules = new LinkedHashMap<>();
    }

    @Override
    public void addReactor(Reactor reactor) {
        this.reactorRepository.put(reactor.getId(), reactor);
    }

    @Override
    public Reactor getReactorById(int reactorId) {
        return this.reactorRepository.get(reactorId);
    }

    @Override
    public Map<Integer, Reactor> getAllReactors() {
        return Collections.unmodifiableMap(this.reactorRepository);
    }

    @Override
    public void addModule(Module module) {
        this.reactorModules.put(module.getId(), module);
    }

    @Override
    public Module getModuleById(int moduleId) {
        return this.reactorModules.get(moduleId);
    }

    @Override
    public Map<Integer, Module> getAllModules() {
        return Collections.unmodifiableMap(this.reactorModules);
    }
}
