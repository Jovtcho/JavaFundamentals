package cresla.entities.reactors;

import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseReactor implements Reactor {
    private int id;
    private Container container;

    protected BaseReactor(int id, Container container) {
        this.id = id;
        this.container = container;
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() throws NoSuchFieldException, IllegalAccessException {
        Class<?> moduleContainerClass = this.container.getClass();
        Field field = moduleContainerClass.getDeclaredField("modulesByInput");
        field.setAccessible(true);
        LinkedList<Module> modules = (LinkedList<Module>) field.get(this.container);

        return modules.size();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        // CryoReactor - 1
        // Energy Output: 4000
        // Heat Absorbing: 10000
        // Modules: 5

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", this.getClass().getSimpleName(), this.getId())).append(System.lineSeparator());
        sb.append(String.format("Energy Output: %d",
                this.getTotalEnergyOutput() > this.getTotalHeatAbsorbing()
                        ? 0
                        : this.getTotalEnergyOutput()))
                .append(System.lineSeparator());
        sb.append(String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing())).append(System.lineSeparator());
        try {
            sb.append(String.format("Modules: %d", this.getModuleCount())).append(System.lineSeparator());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return sb.toString().trim();
    }
}
