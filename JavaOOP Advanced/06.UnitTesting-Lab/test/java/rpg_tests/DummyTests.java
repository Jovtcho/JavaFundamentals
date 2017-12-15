package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;
import rpg_lab.interfaces.Weapon;

import java.util.ArrayList;

public class DummyTests {
    private static final int INITIAL_DUMMY_HEALTH = 20;
    private static final int INITIAL_DUMMY_EXPERIENCE = 20;

    private Dummy dummy;

    @Before
    public void before() {
        this.dummy = new Dummy(INITIAL_DUMMY_HEALTH, INITIAL_DUMMY_EXPERIENCE, new ArrayList<Weapon>());
    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        int attackPoints = INITIAL_DUMMY_HEALTH / 2;
        this.dummy.takeAttack(attackPoints);

        Assert.assertEquals("Wrong lose health",
                this.dummy.getHealth(), INITIAL_DUMMY_HEALTH - attackPoints);
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowExceptionIfAttacked() {
        int attackPoints = INITIAL_DUMMY_HEALTH;

        this.dummy.takeAttack(attackPoints);
        this.dummy.takeAttack(attackPoints);
    }

    @Test
    public void deadDummyGivesXpPoints() {
        int attackPoints = INITIAL_DUMMY_HEALTH + 1;
        this.dummy.takeAttack(attackPoints);
        Assert.assertEquals("Wrong given experience",
                INITIAL_DUMMY_EXPERIENCE, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void notDeadDummyCannotGiveXpPoints() {
        this.dummy.giveExperience();
    }
}
