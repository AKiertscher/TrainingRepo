//Adam Kiertscher 10/14/20

package com.ss.basics.dayone;

import java.util.Scanner;

public class Chippies {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean playGame = true, innerGameLoop;	
		String playerOne, playerTwo, caseCheck1, caseCheck2, boolCheck;
		int chipPile, chipOne = 0, chipTwo = 0, chipMax, chipTake;
		
		while (playGame == true) {
			System.out.println("What is the name of the first player?: ");
			playerOne = input.next();
			System.out.println("What is the name of the second player?: ");
			playerTwo = input.next();			

			caseCheck1 = playerOne.toLowerCase();
			caseCheck2 = playerTwo.toLowerCase();
			
			while (caseCheck1.equals(caseCheck2)) {
				System.out.println("Both players cannot be named " + playerOne + ". Enter a different name: ");
				playerTwo = input.next();
				caseCheck2 = playerTwo.toLowerCase();
			}

			System.out.println("How many chips does the initial pile contain?");
			chipPile = input.nextInt();
			
			if (chipPile < 3) {
				System.out.println("You have to start with at least 3 chips. Choose another number: ");
				chipPile = input.nextInt();
			}
			
			while ((chipPile % 2) == 0 ) {
				System.out.println("You have to start with an odd number of chips. Choose another number: ");
				chipPile = input.nextInt();	
				if (chipPile < 3) {
					System.out.println("You have to start with at least 3 chips. Choose another number: ");
					chipPile = input.nextInt();
				}
			}		
			
			if ((chipPile % 2) == 0) {
				chipMax = chipPile / 2;
			}
			else {
				chipMax = (chipPile - 1) / 2;
			}	
			
			//board value resets
			innerGameLoop = true;	
			chipOne = 0; 
			chipTwo = 0;
			while (innerGameLoop == true) {
				System.out.println(playerOne + " has " + chipOne + " chips.");
				System.out.println(playerTwo + " has " + chipTwo + " chips.");
				System.out.println("It is your turn, " + playerOne + ".");
				System.out.println("There are " + chipPile + " chips remaining.");
				System.out.println("You may take any number of chips from 1 to "
							+ chipMax + ". How many will you take, "
							+ playerOne + "?");				
				chipTake = input.nextInt();
				
				while ((chipTake < 1) || (chipTake > chipMax)) {
					if (chipTake < 1) {
						System.out.println("Illegal move: you must take at least one chip.");
						System.out.println("How many will you take, " + playerOne + "?");
						chipTake = input.nextInt();
					}
					else if (chipTake > chipMax) {
						System.out.println("Illegal move: you may not take more than " + chipMax + " chips.");
						System.out.println("How many will you take, " + playerOne + "?");
						chipTake = input.nextInt();
					}
				}		
				
				chipOne = chipOne + chipTake;
				chipPile = chipPile - chipTake;		
				if (chipPile <= 3) {
					chipMax = 1;
				}
				else if ((chipPile % 2) == 0) {
					chipMax = chipPile / 2;
				}
				else {
					chipMax = (chipPile - 1) / 2;
				}				
				
				if (chipPile == 0) {
					System.out.println(playerOne + " has " + chipOne + " chips.");
					System.out.println(playerTwo + " has " + chipTwo + " chips.");
					innerGameLoop = false;
					if (chipOne > chipTwo) {
						System.out.println(playerOne + " wins!");
					}
					else {
						System.out.println(playerTwo + " wins!");
					}
					break;
				}				
				
				System.out.println("It is your turn, " + playerTwo + ".");
				System.out.println("There are " + chipPile + " chips remaining.");
				System.out.println("You may take any number of chips from 1 to "
							+ chipMax + ". How many will you take, "
							+ playerTwo + "?");				
				chipTake = input.nextInt();			
				
				while ((chipTake < 1) || (chipTake > chipMax)) {
					if (chipTake < 1) {
						System.out.println("Illegal move: you must take at least one chip.");
						System.out.println("How many will you take, " + playerTwo + "?");
						chipTake = input.nextInt();
					}
					else if (chipTake > chipMax) {
						System.out.println("Illegal move: you may not take more than " + chipMax + " chips.");
						System.out.println("How many will you take, " + playerTwo + "?");
						chipTake = input.nextInt();
					}
				}
				
				chipTwo = chipTwo + chipTake;
				chipPile = chipPile - chipTake;		
				if (chipPile <= 3) {
					chipMax = 1;
				}
				else if ((chipPile % 2) == 0) {
					chipMax = chipPile / 2;
				}
				else {
					chipMax = (chipPile - 1) / 2;
				}

				if (chipPile == 0) {
					System.out.println(playerOne + " has " + chipOne + " chips.");
					System.out.println(playerTwo + " has " + chipTwo + " chips.");
					if (chipOne > chipTwo) {
						System.out.println(playerOne + " wins!");
					}
					else {
						System.out.println(playerTwo + " wins!");
					}
					innerGameLoop = false;
				}
			}// end of inner game loop
			
			System.out.println("Play another game? (y/n)");			
			boolCheck = input.next();
			
			if (boolCheck.equals("n")) {
				playGame = false;
			}			
			
		}// end of main game loop
		System.out.println("Thanks for playing!");
        input.close();
	}
}
