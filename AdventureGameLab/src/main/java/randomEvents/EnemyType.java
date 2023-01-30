package randomEvents;

import java.util.Random;

public enum EnemyType {
    GOBLIN("a goblin", 40, 7,"Goblin: I'm gonna stab yuz in tha bum!"),
    ORC("an orc", 85, 22, "Orc: Yuz ready for a krumpin!"),
    ZOMBIE("a zombie", 70, 12, "Zombie: mmmmmmm mmmm uuur rrrrrr uuugghhh..."),
    ELDRITCHORROR("an eldritch horror", 160, 35, "Eldritch Horror: *$^@£^%)$%£@@! )*&$&@&$(£@"),
    FALLENHERO("a fallen hero", 200, 26, "Fallen Hero: Give in to the dark gods, let the voices open your mind...");

    private String type;
    private int enemyHP;
    private int enemyDamage;
    private String battleCry;

    EnemyType(String type, int enemyHP, int enemyDamage, String battleCry) {
        this.type = type;
        this.enemyHP = enemyHP;
        this.enemyDamage = enemyDamage;
        this.battleCry = battleCry;
    }

    public String getType() {
        return this.type;
    }

    public int getEnemyHP() {
        return this.enemyHP;
    }

    public String getBattleCry() {
        return this.battleCry;
    }

    public int getEnemyDamage(){
        return this.enemyDamage;
    }

    public static EnemyType getRandomEnemy(){
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}




