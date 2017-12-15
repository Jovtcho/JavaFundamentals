package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.interfaces.RandomProvider;
import rpg_lab.interfaces.RandomProviderImpl;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTests {
    private static final int TARGET_EXPERIENCE = 20;
    private static final String HERO_NAME = "Goshu";

    private Hero hero;
    private Weapon weaponMocked;
    private Target targetMocked;
    private RandomProvider randomMocked;

    @Before
    public void init() {
        this.weaponMocked = Mockito.mock(Weapon.class);
        this.targetMocked = Mockito.mock(Target.class);
        this.randomMocked = Mockito.mock(RandomProvider.class);
        this.hero = new Hero(HERO_NAME, this.weaponMocked);
    }

    @Test
    public void heroTakesXpIfTargetDies() {
        Mockito.when(this.targetMocked.isDead()).thenReturn(true);
        Mockito.when(this.targetMocked.giveExperience()).thenReturn(TARGET_EXPERIENCE);

        this.hero.attack(this.targetMocked, new RandomProviderImpl());
        Assert.assertEquals("Experience is not taken",
                this.targetMocked.giveExperience(), this.hero.getExperience());
    }

    @Test
    public void heroTakesRandomWeaponIfTargetDies() {
        Mockito.when(this.targetMocked.isDead()).thenReturn(true);
        Mockito.when(this.targetMocked.giveWeapon(this.randomMocked)).thenReturn(this.weaponMocked);

        this.hero.attack(this.targetMocked, this.randomMocked);
        Assert.assertSame(this.weaponMocked, this.hero.getInventory().iterator().next());
    }
}
