package room;

import enemy.Enemy;
import player.Player;

public class Room {
    Player player;
    Enemy enemy;

    public Room( Enemy enemy) {
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
