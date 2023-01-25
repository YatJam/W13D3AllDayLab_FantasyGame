package player;

import behaviours.IWeapon;
import enemy.Enemy;

public abstract class Fighter extends Player {

    private IWeapon iWeapon;

    public Fighter(String name, int healthPoints, IWeapon iWeapon) {
        super(name, healthPoints);
        this.iWeapon = iWeapon;
    }

    public IWeapon getiWeapon() {
        return this.iWeapon;
    }

    public void setiWeapon(IWeapon iWeapon) {
        this.iWeapon = iWeapon;
    }

    public String attack(Enemy enemy){
        enemy.setHealthPoints(enemy.getHealthPoints() - this.iWeapon.damageValue()) ;
//        return "You have attacked " + enemy.getName() + " HP remaining " + enemy.getHealthPoints();
        return String.format("You have attacked %s HP remaining %s",enemy.getName(), String.valueOf(enemy.getHealthPoints()));
    }


}
