package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;

public class ModuleContainerTest {
    private static final int DEFAULT_MODULE_CONTAINER_CAPACITY = 2;
    private Container moduleContainer;
    private EnergyModule energyModuleMocked1;
    private EnergyModule energyModuleMocked2;
    private EnergyModule energyModuleMocked3;
    private AbsorbingModule absorbingModuleMocked1;
    private AbsorbingModule absorbingModuleMocked2;
    private AbsorbingModule absorbingModuleMocked3;

    @Before
    public void setUp() {
        this.moduleContainer = new ModuleContainer(DEFAULT_MODULE_CONTAINER_CAPACITY);

        this.energyModuleMocked1 = Mockito.mock(EnergyModule.class);
        Mockito.when(this.energyModuleMocked1.getId()).thenReturn(1);
        Mockito.when(this.energyModuleMocked1.getEnergyOutput()).thenReturn(2000000000);

        this.energyModuleMocked2 = Mockito.mock(EnergyModule.class);
        Mockito.when(this.energyModuleMocked2.getId()).thenReturn(2);
        Mockito.when(this.energyModuleMocked2.getEnergyOutput()).thenReturn(2000000000);

        this.energyModuleMocked3 = Mockito.mock(EnergyModule.class);
        Mockito.when(this.energyModuleMocked3.getId()).thenReturn(3);

        this.absorbingModuleMocked1 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(this.absorbingModuleMocked1.getId()).thenReturn(1);
        Mockito.when(this.absorbingModuleMocked1.getHeatAbsorbing()).thenReturn(2000000000);

        this.absorbingModuleMocked2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(this.absorbingModuleMocked2.getId()).thenReturn(2);
        Mockito.when(this.absorbingModuleMocked2.getHeatAbsorbing()).thenReturn(2000000000);

        this.absorbingModuleMocked3 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(this.absorbingModuleMocked3.getId()).thenReturn(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullEnergyModuleShouldThrowIllegalArgumentException() {
        //Arrange
        EnergyModule energyModule = null;

        //Act
        this.moduleContainer.addEnergyModule(energyModule);
        //Assert
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullAbsorbingModuleShouldThrowIllegalArgumentException() {
        //Arrange
        AbsorbingModule absorbingModule = null;

        //Act
        this.moduleContainer.addAbsorbingModule(absorbingModule);
        //Assert
    }

    @Test
    public void addEnergyModule() throws NoSuchFieldException, IllegalAccessException {

        //Act
        this.moduleContainer.addEnergyModule(this.energyModuleMocked1);
        this.moduleContainer.addEnergyModule(this.energyModuleMocked2);
        this.moduleContainer.addEnergyModule(this.energyModuleMocked3);

        Class<?> containerClass = this.moduleContainer.getClass();
        Field energyModulesField = containerClass.getDeclaredField("energyModules");
        energyModulesField.setAccessible(true);
        Map<Integer, EnergyModule> energyModules = (Map<Integer, EnergyModule>) energyModulesField.get(this.moduleContainer);
        boolean isContainLastEnergyModuleId = energyModules.containsKey(3);
        boolean isContainFirstEnergyModuleId = !energyModules.containsKey(1);
        boolean isModuleAddCorrectly = isContainLastEnergyModuleId && isContainFirstEnergyModuleId;

        //Assert
        Assert.assertEquals("Energy module is not added properly", true, isModuleAddCorrectly);
    }

    @Test
    public void addAbsorbingModule() throws NoSuchFieldException, IllegalAccessException {

        //Act
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMocked1);
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMocked2);
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMocked3);

        Class<?> containerClass = this.moduleContainer.getClass();
        Field absorbingModulesField = containerClass.getDeclaredField("absorbingModules");
        absorbingModulesField.setAccessible(true);
        Map<Integer, AbsorbingModule> absorbingModules = (Map<Integer, AbsorbingModule>) absorbingModulesField.get(this.moduleContainer);
        boolean isContainLastAbsorbingModuleId = absorbingModules.containsKey(3);
        boolean isContainFirstAbsorbingModuleId = !absorbingModules.containsKey(1);
        boolean isModuleAddCorrectly = isContainLastAbsorbingModuleId && isContainFirstAbsorbingModuleId;

        //Assert
        Assert.assertEquals("Absorbing module is not added properly", true, isModuleAddCorrectly);
    }

    @Test
    public void getTotalEnergyOutputShouldReturnSumOfAllEnergyOutputValuesLong() {

        //Act
        this.moduleContainer.addEnergyModule(this.energyModuleMocked1);
        this.moduleContainer.addEnergyModule(this.energyModuleMocked2);

        //Assert
        Assert.assertEquals("Energy output value is incorrect",
                4000000000L, this.moduleContainer.getTotalEnergyOutput());
    }

    @Test
    public void getTotalHeatAbsorbingShouldReturnSumOfAllHeatAbsorbingValuesLong() {

        //Act
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMocked1);
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMocked2);

        //Assert
        Assert.assertEquals("Heat absorbing value is incorrect",
                4000000000L, this.moduleContainer.getTotalHeatAbsorbing());
    }
}