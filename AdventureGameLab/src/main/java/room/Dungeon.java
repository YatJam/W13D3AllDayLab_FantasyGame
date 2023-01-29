package room;

import java.util.ArrayList;

public class Dungeon {

    private ArrayList<Room> roomList;

    public Dungeon(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    public ArrayList<Room> getRoomList() {
        return this.roomList;
    }

    public void addRoomToList(Room room){
        this.roomList.add(room);
    }

    public int roomCount(){
        return this.roomList.size();
    }
}
