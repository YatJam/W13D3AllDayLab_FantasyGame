package player;

import behaviours.IBattleCry;
import room.Room;
import weapon.Weapon;

public class Dwarf extends Fighter implements IBattleCry {
    public Dwarf(String name, Weapon weapon) {
        super(name, 140, weapon);
    }

    public String getBattleCry() {
        return getName() + ": Even my nan's croissant has more resilience than you...\nI'm calling you a coward!";
    }
}
