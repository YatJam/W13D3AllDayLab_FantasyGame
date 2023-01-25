package Game;

import room.RoomExit;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class GameManager {

    private final List<RoomExit> roomExitList;
    private RoomExit nextRoom;




    public GameManager() {
       this.roomExitList = Arrays.asList(RoomExit.EAST, RoomExit.SOUTH, RoomExit.WEST, RoomExit.NORTH);
       this.nextRoom = null;
    }

    public List<RoomExit> getRoomExitList() {
        return this.roomExitList;
    }

    public void getRandomRoom(){
        Random rand = new Random();
       RoomExit randomExit = roomExitList.get(rand.nextInt(roomExitList.size()));
       this.nextRoom = randomExit;
    }

    public RoomExit getNextRoom() {
        return this.nextRoom;
    }

    public void setNextRoom(RoomExit nextRoom) {
        this.nextRoom = nextRoom;
    }
}
