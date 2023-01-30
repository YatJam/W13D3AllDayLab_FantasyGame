package randomEvents;

import behaviours.IRandomEncounter;

public class Treasure implements IRandomEncounter {
    private TreasureType treasureType;
    private String name;
    private int value;

    public Treasure(TreasureType treasureType) {
        this.treasureType = treasureType;
        this.name = treasureType.getType();
        this.value = treasureType.getValue();
    }

    public TreasureType getTreasureType() {
        return this.treasureType;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }


    @Override
    public String randomEvent() {
        return "You have found a wooden chest that draws your curiosity.";
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isEnemy() {
        return false;
    }
}
