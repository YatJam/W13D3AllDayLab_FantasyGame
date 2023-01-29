package player;

import behaviours.IBattleCry;
import randomEvents.Enemy;
import room.Room;
import weapon.Weapon;

import java.util.Random;

public abstract class Fighter extends Player implements IBattleCry {

    private Weapon weapon;

    public Fighter(String name, int HP, Weapon weapon) {
        super(name, HP);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getDamage(){
        return getWeapon().getDamageValue();
    }

    public int dealRandomDamage(){
        Random rand = new Random();
        return rand.nextInt(getDamage() + 1);
    }

    public String attack (Enemy enemy){
        int randomDamage = dealRandomDamage();
        enemy.setEnemyHP(enemy.getEnemyHP() - randomDamage);
        return "You have dealt a crippling blow of " + randomDamage +" damage.\nYour enemy will know fear: "+enemy.getEnemyHP()+"HP";
    }

}
