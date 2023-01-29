package room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExitMaker {

    public static String randomExitGenerator() {
        Random rand = new Random();
        List<String> randomExitList = new ArrayList<>();
        randomExitList.add(ExitDirection.NORTH.getString());
        randomExitList.add(ExitDirection.EAST.getString());
        randomExitList.add(ExitDirection.SOUTH.getString());
        randomExitList.add(ExitDirection.WEST.getString());


        int numberOfElements = rand.nextInt(randomExitList.size()) + 1;

        String randomElement = null;
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(randomExitList.size());
            randomElement = randomExitList.get(randomIndex);
            randomExitList.remove(randomIndex);

        }
        return randomExitList.toString();
    }
}
