package weapon;

import behaviours.IWeapon;

public class Axe implements IWeapon {

    private int damageValue;

    public Axe(int damageValue) {
        this.damageValue = 90;
    }


    public int damageValue() {
        return this.damageValue;
    }
}
