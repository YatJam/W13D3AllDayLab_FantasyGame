package Game;

import java.util.Scanner;
import player.Barbarian;

public class GameRunner {

        public static void main (String[]args){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("WELCOME TO THE GAME");
            System.out.println("Please enter your name: ");

            String userName = myObj.nextLine();
            System.out.println("Welcome " + userName + " are you ready??" );
// Read user input
            System.out.println("Please choose a player: ");

            String chosenplayer = myObj.nextLine();  // Read user input
            System.out.println("You have chosen " + chosenplayer);  // Output user input

            System.out.println("Your player " + chosenplayer + " must have a weapon, please chose a weapon to vanquish to denizens of evil: " );  // Output user input
            String chosenWeapon = myObj.nextLine();  // Read user input
            System.out.println("You have chosen " + chosenWeapon);  // Output user input

            String awaken = myObj.nextLine();
            System.out.println("You awake in a darkened room, you can hazily make out several exits..." );  // Output user input
            String choseExit = myObj.nextLine();  // Read user input
            System.out.println("Chose an exit: " + choseExit);  // Output user input

            String chosenExit = myObj.nextLine();  // Read user input
            System.out.println("You have chosen " + chosenExit);  // Output user input




        }

    }
