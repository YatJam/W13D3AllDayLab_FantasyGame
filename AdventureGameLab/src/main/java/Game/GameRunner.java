package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

import behaviours.IRandomEncounter;
import combatMechanic.Combat;
import player.*;
import randomEvents.Enemy;
import randomEvents.Treasure;
import room.Dungeon;
import room.ExitMaker;
import room.Room;
import weapon.Axe;
import weapon.Club;
import weapon.Sword;
import weapon.Weapon;

public class GameRunner {

    public static void main (String[]args) {

    String heroType;
    String weaponType;
    String firstExit;
    Weapon weapon = null;
    Boolean exit = false;
    Player player1 = null;
//    int currentRoomNumber = 0;

    Room startRoom = new Room("A dimly lit room");
    Room randomRoom1 = new Room("Damp Cell");
    Room randomRoom2 = new Room("Infirmary");
    Room randomRoom3 = new Room("Nursery");
    Room randomRoom4 = new Room("Workshop");
    Room randomRoom5 = new Room("Mortuary");
    Room randomRoom6 = new Room("The Old Warden's Office");
    Room randomRoom7 = new Room("Dry Cell");
    Room randomRoom8 = new Room("Armoury");
    Room randomRoom9 = new Room("Dark Corridor");
    Room randomRoom10 = new Room("Torture Chamber");
    Room randomRoom11 = new Room("Oblivion");
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(startRoom);
        roomList.add(randomRoom1);
        roomList.add(randomRoom2);
        roomList.add(randomRoom3);
        roomList.add(randomRoom4);
        roomList.add(randomRoom5);
        roomList.add(randomRoom6);
        roomList.add(randomRoom7);
        roomList.add(randomRoom8);
        roomList.add(randomRoom9);
        roomList.add(randomRoom10);
        roomList.add(randomRoom11);
        Dungeon dungeon = new Dungeon(roomList);

        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome, brave adventurer! What's your name?");
        String playerName = scan.nextLine();

        System.out.println("Greetings, " + playerName + "!");
        String ourCastle = scan.nextLine();

        String decision;
        do {
            System.out.println("Our castle has been plagued with unknown horrors, can you save us?");
            System.out.println("Y/N");
            decision = scan.nextLine();
        } while (!(decision.matches("Y|N")));

        if (decision.equals("Y")) {
            System.out.println("Ah my sweet chicken, thank you for your offering your soul...\n");
        } else {
            System.out.println("Ok, well bye then...\nGAME OVER");
            System.exit(0);
        }

        do {
            System.out.println("Tell us, what kind of hero are you?");
            System.out.println("Pick your hero by typing one of the options: Barbarian, Dwarf, Knight");
            heroType = scan.nextLine();
        } while (!(heroType.matches("Barbarian|Dwarf|Knight")));

        System.out.println("You will need a weapon to fight these denizens of evil!");

        do {
            System.out.println("Pick one of the options: axe, club or sword.");
            weaponType = scan.nextLine();
        } while (!(weaponType.matches("axe|club|sword")));

        switch(weaponType){
            case "axe": weapon = new Axe();
            break;
            case "club": weapon = new Club();
            break;
            case "sword": weapon = new Sword();
            break;
            }

            switch(heroType){
                case "Barbarian": player1 = new Barbarian(playerName, weapon);
                break;
                case "Dwarf": player1 = new Dwarf(playerName, weapon);
                break;
                case "Knight": player1 = new Knight(playerName, weapon);
                break;
        }

        String chosenPlayer = scan.nextLine();
        System.out.println("You are a ferocious " + heroType + " wielding a trusty " + weaponType + "!\nYour starting health is: " + player1.getHealthPoints() + ", Your " + weapon.getWeaponName()  + " deals " + weapon.getDamageValue() + " damage!");

        String bonk = scan.nextLine();
        System.out.println("...BONK...");

        String awaken = scan.nextLine();
        System.out.println("You awake in a dark room, you can hazily make out several exits...");
        do{
        System.out.println("Pick one of the following exits:" + ExitMaker.randomExitGenerator());
        firstExit = scan.nextLine();
    } while (!(firstExit.matches("North|East|South|West")));

        System.out.println("You stumble towards what you perceive is " + firstExit + " and exit the room.");

        String pause1 = scan.nextLine();
        System.out.println("\n------------------");
        System.out.println("\nYOU ARE IN ANOTHER ROOM!");

        GameManager gameManager = new GameManager(dungeon, player1);
        gameManager.playerMoveToNextRoom(player1);
        System.out.println();

        while (!(exit)){
            ArrayList<String> availableActions = new ArrayList<>();
            availableActions.addAll(Arrays.asList("search room", "check inventory", "check health", "eat malteasers", "exit room", "quit game"));

            System.out.println("You believe you are currently in the " + player1.getCurrentRoom().getName() + ".");
            System.out.println("What actions shall you take?\n");
            System.out.println("Available actions: " + availableActions);
            String actionChoice = scan.nextLine();

            switch(actionChoice){
                case "search room":
                    System.out.println(player1.searchRoom());
                    IRandomEncounter randomEncounter = player1.getCurrentRoom().getIRandomEncounter();
                    if(randomEncounter != null && randomEncounter.isTreasure()){
                        System.out.println("Do you wish to open it?\nY/N");
                        do {
                            actionChoice = scan.nextLine();
                        } while (!(actionChoice).matches("Y|N"));
                        if((actionChoice).equals("Y")){
                            System.out.println(player1.collectTreasure());
                        }
                    } else if (randomEncounter != null && randomEncounter.isEnemy()) {
                        Combat combat = new Combat();
                        System.out.println(combat.battle(player1));
                    }
                    break;
                case "exit room":
                    if(gameManager.getCurrentRoomNumber() < (dungeon.getRoomList().size()-1)){
                        do {
                            System.out.println("Pick one of the following exits:" + ExitMaker.randomExitGenerator());
                            firstExit = scan.nextLine();
                        } while (!(firstExit.matches("North|East|South|West")));
                        System.out.println("You stumble towards what you perceive is " + firstExit + " and exit the room.");
                                gameManager.playerMoveToNextRoom(player1);
                    } else {
                        System.out.println("In the dim haze of a rotting corridor, you catch a faint breeze of cool air through the miasma.\nHearing otherworldly abominations call out in the darkness, you frantically follow the sent.../nTurning a corner, you catch a glimpse of a stairwell winding upwards\nYou seek your salvation\n\nGAME OVER");
                        System.out.println("Items collected:");
                        System.out.println("----------------------------------------");
                        ArrayList< Treasure> pack = player1.getPack();
                        int score = 0;
                        for (Treasure item:pack){
                            System.out.println("Item: " + item.getName() + ", value: " + item.getValue() + "gp.");
                            score += item.getValue();
                        }
                    System.out.println("------------------------------");
                    System.out.println("Overall score: " + score + "gp");
                    exit = true;
                }
                break;
                case "check inventory":
                    System.out.println("All items in your backpack:");
                    ArrayList<Treasure> pack = player1.getPack();
                    for(Treasure item:pack){
                        System.out.println("Item: " + item.getName() + ", value: " + item.getValue() + "gp.");
                    }
                    System.out.println("\n");
                    break;
                case "check health":
                    System.out.println("Your health points: " + player1.getHealthPoints() + "\n");
                    break;
                case "eat malteasers":
                    System.out.println(player1.eatChocolate());
                    break;
                case "quit game":
                    exit = true;
                    break;
            }
            if (player1.getHealthPoints() <= 0){
                exit = true;
            }
        }


    }

}