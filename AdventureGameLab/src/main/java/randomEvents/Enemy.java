package randomEvents;

import behaviours.IRandomEncounter;
import player.Player;

import java.util.Random;

public class Enemy implements IRandomEncounter {

    private String type;
    private EnemyType enemyType;
    private int enemyHP;
    private int enemyDamange;
    private String battleCry;

    public Enemy(EnemyType enemyType) {
        this.type = enemyType.getType();
        this.enemyType = enemyType;
        this.enemyHP = enemyType.getEnemyHP();
        this.enemyDamange = enemyType.getEnemyDamage();
        this.battleCry = enemyType.getBattleCry();
    }

    public String getType() {
        return this.type;
    }

    public EnemyType getEnemyType() {
        return this.enemyType;
    }

    public int getEnemyHP() {
        return this.enemyHP;
    }

    public void setEnemyHP(int enemyHP){
        this.enemyHP = enemyHP;
    }

    public int getEnemyDamange() {
        return this.enemyDamange;
    }

    public String getBattleCry() {
        return this.battleCry;
    }

    @Override
    public String randomEvent() {
        return "You suddenly become aware that you are not alone...";
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isEnemy() {
        return true;
    }

    public int dealRandomDamage(){
        Random rand = new Random();
        return rand.nextInt(getEnemyDamange() + 1);
    }

    public String attack(Player player){
        int randomDamage = dealRandomDamage();
        player.setHealthPoints(player.getHealthPoints() - randomDamage);
        return "The enemy bests your defensive prowess and deals " + randomDamage +" damage.\nYour health is: " + player.getHealthPoints()+"HP";
    }
}
