package room;

import behaviours.IRandomEncounter;
import player.Player;
import randomEvents.Enemy;
import randomEvents.EnemyType;
import randomEvents.Treasure;
import randomEvents.TreasureType;

import java.util.ArrayList;
import java.util.Random;

public class Room {
    private String name;
    private ArrayList<Player> playerPresent;
    private IRandomEncounter iRandomEncounter;

    public Room(String name) {
        this.name = name;
        this.playerPresent = new ArrayList<>();
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if(randomNumber == 0){
            this.iRandomEncounter = new Treasure(TreasureType.getRandomTreasureType());
        } else {
            this.iRandomEncounter = new Enemy(EnemyType.getRandomEnemy());
        }

    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Player> getPlayerPresent() {
        return this.playerPresent;
    }

    public IRandomEncounter getIRandomEncounter() {
        return this.iRandomEncounter;
    }

    public void addPlayerToRoom(Player player){
        playerPresent.add(player);
        player.setCurrentRoom(this);
    }

    public void removePlayerFromRoom(Player player){
        playerPresent.remove(player);
    }

    public void removeRandomEncounter(){
        iRandomEncounter = null;
    }
}
