package room;

public enum ExitDirection {
    NORTH("North"),
    EAST("East"),
    SOUTH("South"),
    WEST("West");

    private final String string;

    ExitDirection(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}

