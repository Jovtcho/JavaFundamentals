package cresla.core;

import cresla.factory.ModuleFactory;
import cresla.factory.ReactorFactory;
import cresla.interfaces.*;

import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private static final String CREATE_REACTOR_MESSAGE = "Created %s Reactor - %d";
    private static final String ADD_MODULE_MESSAGE = "Added %s - %d to Reactor - %d";

    private Identifiable identifiable;
    private Repository reactorRepository;

    public ManagerImpl(Identifiable identifiable, Repository reactorRepository) {
        this.identifiable = identifiable;
        this.reactorRepository = reactorRepository;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        int id = this.identifiable.getId();
        String reactorType = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));
        Reactor reactor = ReactorFactory.createReactor(reactorType, id, additionalParameter, moduleCapacity);
        if (reactor != null) {
            this.reactorRepository.addReactor(reactor);
            return String.format(CREATE_REACTOR_MESSAGE, reactorType, reactor.getId());
        }

        return null;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int moduleId = this.identifiable.getId();
        int reactorId = Integer.parseInt(arguments.get(0));
        String moduleType = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));
        Reactor reactor = this.reactorRepository.getReactorById(reactorId);

        if ("CryogenRod".equalsIgnoreCase(moduleType)) {
            EnergyModule energyModule = ModuleFactory.createEnergyModule(moduleType, moduleId, additionalParameter);
            if (energyModule != null) {
                this.reactorRepository.addModule(energyModule);
                if (this.reactorRepository.getAllReactors().containsKey(reactorId)) {
                    reactor.addEnergyModule(energyModule);
                    return String.format(ADD_MODULE_MESSAGE, moduleType, energyModule.getId(), reactor.getId());
                }
            }
        } else {
            AbsorbingModule absorbingModule = ModuleFactory.createAbsorbingModule(moduleType, moduleId, additionalParameter);
            if (absorbingModule != null) {
                this.reactorRepository.addModule(absorbingModule);
                if (this.reactorRepository.getAllReactors().containsKey(reactorId)) {
                    reactor.addAbsorbingModule(absorbingModule);
                    return String.format(ADD_MODULE_MESSAGE, moduleType, absorbingModule.getId(), reactor.getId());
                }
            }
        }

        return null;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));

        if (this.reactorRepository.getAllReactors().containsKey(id)) {
            Reactor reactor = this.reactorRepository.getReactorById(id);
            if (reactor != null) {
                return reactor.toString();
            }
        }

        if (this.reactorRepository.getAllModules().containsKey(id)) {
            Module module = this.reactorRepository.getModuleById(id);
            if (module != null) {
                return module.toString();
            }
        }

        return null;
    }

    @Override
    public String exitCommand(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();

        Map<Integer, Reactor> reactors = this.reactorRepository.getAllReactors();
        Map<Integer, Module> modules = this.reactorRepository.getAllModules();
        int cryoReactorsCount = 0;
        int heatReactorsCount = 0;
        int energyModulesCount = 0;
        int absorbingModulesCount = 0;
        long totalEnergyOutput = 0;
        long totalHeatAbsorbing = 0;

        for (Reactor reactor : reactors.values()) {
            String reactorClassName = reactor.getClass().getSimpleName();

            if (reactorClassName.startsWith("Cryo")) {
                cryoReactorsCount++;
            }
            if (reactorClassName.startsWith("Heat")) {
                heatReactorsCount++;
            }

            totalEnergyOutput += reactor.getTotalEnergyOutput() > reactor.getTotalHeatAbsorbing()
                    ? 0
                    : reactor.getTotalEnergyOutput();
            totalHeatAbsorbing += reactor.getTotalHeatAbsorbing();
        }

        for (Module module : modules.values()) {
            String moduleClassName = module.getClass().getSuperclass().getSimpleName();

            if (moduleClassName.endsWith("EnergyModule")) {
                energyModulesCount++;
            }
            if (moduleClassName.endsWith("AbsorberModule")) {
                absorbingModulesCount++;
            }
        }

        // Cryo Reactors: 1
        // Heat Reactors: 1
        // Energy Modules: 6
        // Absorbing Modules: 2
        // Total Energy Output: 10249
        // Total Heat Absorbing: 20250

        sb.append(String.format("Cryo Reactors: %d", cryoReactorsCount)).append(System.lineSeparator());
        sb.append(String.format("Heat Reactors: %d", heatReactorsCount)).append(System.lineSeparator());
        sb.append(String.format("Energy Modules: %d", energyModulesCount)).append(System.lineSeparator());
        sb.append(String.format("Absorbing Modules: %d", absorbingModulesCount)).append(System.lineSeparator());
        sb.append(String.format("Total Energy Output: %d", totalEnergyOutput)).append(System.lineSeparator());
        sb.append(String.format("Total Heat Absorbing: %d", totalHeatAbsorbing)).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
