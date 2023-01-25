package enemy;

public abstract class Enemy {

    private int healthPoints;

    private String name;

    public Enemy(int healthPoints, String name) {
        this.healthPoints = healthPoints;
        this.name = name;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEnemyDead() {
        return this.healthPoints <= 0;
    }
}
