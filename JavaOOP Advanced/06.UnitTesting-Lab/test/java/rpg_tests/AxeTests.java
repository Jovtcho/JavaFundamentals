package rpg_tests;

//import org.junit.jupiter.api.Test;

import exceptions.BrokenWeapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.interfaces.Weapon;

import java.util.ArrayList;

public class AxeTests {
    private static final int INITIAL_AXE_ATTACK = 10;
    private static final int INITIAL_AXE_DURABILITY = 10;
    private static final int INITIAL_DUMMY_HEALTH = 100;
    private static final int INITIAL_DUMMY_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void before() {
        this.axe = new Axe(INITIAL_AXE_ATTACK, INITIAL_AXE_DURABILITY);
        this.dummy = new Dummy(INITIAL_DUMMY_HEALTH, INITIAL_DUMMY_EXPERIENCE, new ArrayList<Weapon>());
    }

    @Test
    public void weaponLoseDurabilityAfterAttack() {
        //arrange

        //act
        int attackCount = INITIAL_AXE_DURABILITY / 2;
        int realAttackCount = 0;
        while (this.dummy.getHealth() > 0 && this.axe.getDurabilityPoints() > attackCount) {
            this.axe.attack(this.dummy);
            realAttackCount++;
        }

        //assert
        Assert.assertEquals("Wrong durability",
                this.axe.getDurabilityPoints(), INITIAL_AXE_DURABILITY - realAttackCount);
    }

    @Test(expected = BrokenWeapon.class) //assert
    public void weaponAttackWhenBroken() {
        //arrange

        //act
        for (int index = 0; index < INITIAL_AXE_DURABILITY + 1; index++) {
            this.axe.attack(this.dummy);
        }
    }
}
