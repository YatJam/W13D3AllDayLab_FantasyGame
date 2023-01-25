import enemy.Troll;
import org.junit.Before;
import org.junit.Test;
import player.Barbarian;
import weapon.Sword;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BarbarianTest {

    Barbarian barbarian;
    Sword sword;
    Troll troll;

    @Before
    public void before() {
        sword = new Sword();
        barbarian = new Barbarian("Thrud", 100, sword);
        troll = new Troll();

    }
    @Test
    public void hasHealthPoints(){
        assertEquals(100, barbarian.getHealthPoints());
    }

    @Test
    public void hasName(){
        assertEquals("Thrud", barbarian.getName());
    }

    @Test
    public void canAttack(){
        barbarian.attack(troll);
        assertEquals(110, troll.getHealthPoints());
        assertEquals("You have attacked Troll HP remaining 70", barbarian.attack(troll));
    }


    }