package gameManagerTests;

import Game.GameManager;
import org.junit.Before;
import org.junit.Test;
import player.Barbarian;
import player.Player;
import randomEvents.Enemy;
import room.Dungeon;
import room.Room;
import weapon.Axe;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameManagerTest {

    GameManager gameManager;
    Dungeon dungeon;
    Barbarian player1;
    Axe axe;
    Room room1;
    Room room2;
    Room room3;

    @Before
    public void before(){
       room1 = new Room("Start Room");
       room2 = new Room("End Room");
       room3 = new Room("Ewa bumhouse");
       player1 = new Barbarian("Chop Chop", axe);
       ArrayList<Room> roomList = new ArrayList<>();
       dungeon = new Dungeon(roomList);
       dungeon.addRoomToList(room1);
       dungeon.addRoomToList(room2);
       dungeon.addRoomToList(room3);
       gameManager = new GameManager(dungeon, player1);
    }

    @Test
    public void checkToSeeIfDungeonRoomListIsPulledToGameManagerIsEmpty(){
        System.out.println(gameManager.getDungeon().getRoomList());
    }

    @Test
    public void checkWhichRoomPlayerOccupies(){
        room1.addPlayerToRoom(player1);
        System.out.println(room1.getPlayerPresent());
        System.out.println(room2.getPlayerPresent());
    }

    @Test
    public void canSetCurrentRoomWhichPlayerOccupies(){
       player1.enterRoom(room2);
       assertEquals("End Room", player1.getCurrentRoom().getName());
    }

    @Test
    public void canPlayerMoveFromRoomToRoomInArrayList(){
        System.out.println(room1.getPlayerPresent());
        System.out.println(room2.getPlayerPresent());
        System.out.println(room3.getPlayerPresent());
        System.out.println("");
        assertEquals("Start Room", player1.getCurrentRoom().getName());
        gameManager.playerMoveToNextRoom(player1);
        assertEquals("End Room", player1.getCurrentRoom().getName());
        System.out.println(room1.getPlayerPresent());
        System.out.println(room2.getPlayerPresent());
        System.out.println(room3.getPlayerPresent());
        System.out.println("");
        gameManager.playerMoveToNextRoom(player1);
        assertEquals("Ewa bumhouse", player1.getCurrentRoom().getName());
        System.out.println(room1.getPlayerPresent());
        System.out.println(room2.getPlayerPresent());
        System.out.println(room3.getPlayerPresent());

    }
}
