package player;

import behaviours.IAttack;
import behaviours.IBattleCry;
import behaviours.IRandomEncounter;
import randomEvents.Treasure;
import room.Room;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Player implements IBattleCry, IAttack {

    private String name;
    private int HP;
    private ArrayList<Treasure> pack;
    private Room currentRoom;

    public Player(String name, int HP) {
        this.name = name;
        this.HP = HP;
        this.pack = new ArrayList<>();
        this.currentRoom = null;
    }

    public String getName() {
        return this.name;
    }

    public int getHealthPoints() {
        return this.HP;
    }

    public void setHealthPoints(int HP){
        this.HP = HP;
    }

    public void setHP(int HP){
        this.HP = HP;
    }

    public ArrayList<Treasure> getPack(){
        return this.pack;
    }

    public void enterRoom(Room room){
        room.addPlayerToRoom(this);
        this.setCurrentRoom(room);
    }

    public String collectTreasure(){
        IRandomEncounter randomEncounter = currentRoom.getIRandomEncounter();
        if(randomEncounter.isTreasure()){
            Treasure treasure = (Treasure) randomEncounter;
            addToPack(treasure);
            currentRoom.removeRandomEncounter();
            return "The gods smile upon you, you have collected " + treasure.getName() + ".\n";
        } else {
            return "Like your soul seeking salvation, there is no treasure in this room";
        }
    }
    public void addToPack(Treasure treasure){
        pack.add(treasure);
    }

    public void removeFromPack(Treasure treasure){
        pack.remove(treasure);
    }

    public String searchRoom(){
        if(currentRoom.getIRandomEncounter() == null){
            return "You do not perceive there to be anything of value in the room\n";
        } else {
            return currentRoom.getIRandomEncounter().randomEvent();
        }
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public String eatChocolate(){
        String result = "No choccies found.\n";
        for(Treasure item:pack){
            if((item.getName()).equals("malteasers")&& HP < 25){
                removeFromPack(item);
                if(25 - HP < 5){
                    HP = 60;
                } else {
                    setHP(HP + 20);
                }
                result = "You've eaten some sweet choccies and feel a new life grown inside you.\n";
                break;
            } else if((item.getName()).equals("malteasers")&& HP >= 25){
                System.out.println("You could eat some delicious choccies but they will not offer any regenerative benefit at your current vigor");
            }
        }
        return result;
    }
}
