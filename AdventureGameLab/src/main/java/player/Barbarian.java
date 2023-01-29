package player;

import behaviours.IBattleCry;
import room.Room;
import weapon.Weapon;

public class Barbarian extends Fighter implements IBattleCry {

    public Barbarian(String name, Weapon weapon) {
        super(name, 120, weapon);
    }

    @Override
    public String getBattleCry() {
        return getName() + ": I am here for your knees";
    }
}
