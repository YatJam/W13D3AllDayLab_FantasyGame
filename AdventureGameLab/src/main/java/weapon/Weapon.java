package weapon;

public class Weapon {

    private int damageValue;
    private String weaponName;

    public Weapon(int damageValue, String weaponName) {
        this.damageValue = damageValue;
        this.weaponName = weaponName;
    }

    public int getDamageValue() {
        return this.damageValue;
    }

    public String getWeaponName() {
        return this.weaponName;
    }
}
