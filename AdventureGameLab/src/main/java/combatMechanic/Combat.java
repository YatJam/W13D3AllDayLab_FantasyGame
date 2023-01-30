package combatMechanic;

import player.Fighter;
import player.Player;
import randomEvents.Enemy;

public class Combat {
    private Player player1;
    private Enemy enemy1;

    public String battle(Player player1){
        Enemy enemy1 = (Enemy) player1.getCurrentRoom().getIRandomEncounter();
        System.out.println("a figure lunges from the darkness...\nYou are being attacked by " + enemy1.getType() + "!");
        String result = "";
        while ((player1.getHealthPoints() > 0) && (enemy1.getEnemyHP() > 0)){
            System.out.println(enemy1.getBattleCry());
            System.out.println(enemy1.attack(player1));
            if(player1.getHealthPoints() <= 0){
                result = "You have been slain by the horrors that dwell within the dark.\nYour body and soul have been bound to the dark legion!\n\nThe Light will find another hero...\n--------------------------------------------\nGAME OVER";
                break;
            }
            System.out.println(player1.getBattleCry());
            System.out.println(player1.attack(enemy1));
            if(enemy1.getEnemyHP() <= 0){
                result = "You have slayed an ally of the darkness, you take another step towards the light.\nHP left: " + player1.getHealthPoints() + ".\n";
                player1.getCurrentRoom().removeRandomEncounter();
                break;
            }

        }
        return result;
    }
}
