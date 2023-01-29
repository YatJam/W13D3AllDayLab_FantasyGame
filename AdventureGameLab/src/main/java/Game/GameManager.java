package Game;

import player.Player;
import room.Dungeon;
import room.Room;
import room.RoomExit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameManager {

    private Dungeon dungeon;
    private Player player1;
    private int currentRoomNumber;

    public GameManager(Dungeon dungeon, Player player1) {
        this.dungeon = dungeon;
        this.player1 = player1;
        this.currentRoomNumber = 0;
        this.dungeon.getRoomList().get(currentRoomNumber).addPlayerToRoom(player1);
    }

    public Dungeon getDungeon() {
        return this.dungeon;
    }

    public void playerMoveToNextRoom(Player player1){
        this.dungeon.getRoomList().get(currentRoomNumber).removePlayerFromRoom(player1);
        this.currentRoomNumber += 1;
        dungeon.getRoomList().get(currentRoomNumber).addPlayerToRoom(player1);
    }
}

