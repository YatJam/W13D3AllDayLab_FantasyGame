package weapon;

import behaviours.IWeapon;

public class Sword implements IWeapon {

    private int damageValue;

    public Sword() {
        this.damageValue = 40;
    }


    public int damageValue() {
        return this.damageValue;
    }
}
