package player;

import behaviours.IBattleCry;
import room.Room;
import weapon.Weapon;

public class Knight extends Fighter implements IBattleCry {

    public Knight(String name, Weapon weapon) {
        super(name, 100, weapon);
    }

    @Override
    public String getBattleCry() {
        return getName() + ": I will tell your mother about this!";
    }
}
