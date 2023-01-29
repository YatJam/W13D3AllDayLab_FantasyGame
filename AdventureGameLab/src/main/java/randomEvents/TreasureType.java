package randomEvents;

import java.util.Random;

public enum TreasureType {

    GOLD("gold", 100),
    MALTEASERS("malteasers", 10),
    AREALLYGOODBOOK("a really good book", 5),
    AKEY("a key", 1),
    ;

    private String type;
    private int value;

    TreasureType(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;
    }

    public static TreasureType getRandomTreasureType(){
        Random random = new Random();
                return values()[random.nextInt(values().length)];
    }
}
