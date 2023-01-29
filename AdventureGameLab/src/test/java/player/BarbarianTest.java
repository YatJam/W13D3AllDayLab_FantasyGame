import org.junit.Before;
import org.junit.Test;
import player.Barbarian;
import randomEvents.Enemy;
import randomEvents.EnemyType;
import room.Room;
import weapon.Sword;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BarbarianTest {

    Barbarian barbarian;
    Sword sword;
    Enemy orc;
    Room room1;
    Room room2;

    @Before
    public void before() {
        room1 = new Room("Start Room");
        room2 = new Room("End Room");
        sword = new Sword();
        barbarian = new Barbarian("THUD", sword);
        orc = new Enemy(EnemyType.ORC);

    }
    @Test
    public void hasHealthPoints(){
        assertEquals(120, barbarian.getHealthPoints());
    }

    @Test
    public void hasName(){
        assertEquals("THUD", barbarian.getName());
    }


    @Test
    public void getWeaponDamage(){
        assertEquals(40, sword.getDamageValue());
    }

    @Test
    public void canMoveToAnotherRoomAndUpdateCurrentRoom(){
        barbarian.enterRoom(room2);
        assertEquals(room2, barbarian.getCurrentRoom());
        assertEquals("End Room", barbarian.getCurrentRoom().getName());
    }


    }