package cresla.factory;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;

public final class ModuleFactory {
    private ModuleFactory() {
    }

    public static EnergyModule createEnergyModule(String moduleType, int id, int additionalParameter) {
        return new CryogenRod(id, additionalParameter);
    }

    public static AbsorbingModule createAbsorbingModule(String moduleType, int id, int additionalParameter) {
        AbsorbingModule absorbingModule = null;

        switch (moduleType) {
            case "HeatProcessor":
                return absorbingModule = new HeatProcessor(id, additionalParameter);
            case "CooldownSystem":
                return absorbingModule = new CooldownSystem(id, additionalParameter);
            default:
                return null;
        }
    }
}
