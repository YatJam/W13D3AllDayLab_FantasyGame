package Game;

import enemy.Enemy;
import player.Player;
import room.Room;

public class Game {
    Player playerInUse;
    Enemy enemyInUse;
    Room roomInUse;

    public Game(Player playerInUse, Enemy enemyInUse, Room roomInUse) {
        this.playerInUse = playerInUse;
        this.enemyInUse = enemyInUse;
        this.roomInUse = roomInUse;
    }

    public Player getPlayerInUse() {
        return playerInUse;
    }

    public void setPlayerInUse(Player playerInUse) {
        this.playerInUse = playerInUse;
    }

    public Enemy getEnemyInUse() {
        return enemyInUse;
    }

    public void setEnemyInUse(Enemy enemyInUse) {
        this.enemyInUse = enemyInUse;
    }

    public Room getRoomInUse() {
        return roomInUse;
    }

    public void setRoomInUse(Room roomInUse) {
        this.roomInUse = roomInUse;
    }
}
