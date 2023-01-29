package roomTests;

import org.junit.Before;
import org.junit.Test;
import room.Dungeon;
import room.Room;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DungeonTest {

    Dungeon dungeon;
    Room room1;
    Room room2;

    @Before
    public void before(){
        room1 = new Room("Start Room");
        room2 = new Room("End Room");
        ArrayList<Room> roomList = new ArrayList<>();
        dungeon = new Dungeon(roomList);
    }

    @Test
    public void roomCountShouldBeZero(){
        assertEquals(0, dungeon.roomCount());
    }

    @Test
    public void addRoomsToArray(){
        dungeon.addRoomToList(room1);
        dungeon.addRoomToList(room2);
        assertEquals(2, dungeon.roomCount());
    }

    @Test
    public void getRoomNameFromArray(){
        dungeon.addRoomToList(room1);
        assertEquals("Start Room", room1.getName());
    }

}
