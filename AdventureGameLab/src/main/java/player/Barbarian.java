package player;

import behaviours.IWeapon;

public class Barbarian extends Fighter{


    public Barbarian(String name, int healthPoints, IWeapon iWeapon) {
        super(name, 100, iWeapon);
    }
}
