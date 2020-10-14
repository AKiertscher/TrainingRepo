//Adam Kiertscher 10/14/20

package com.ss.basics.dayone;

import java.util.Scanner;
import java.util.Random; 

public class NumberGuesser {

	public static void main(String[] args) {
		 
        Random rand = new Random(); 
        int guessCounter = 1;
        int guess;
        int checker;        
        int randomInt = rand.nextInt(99); //generates random number between 0-99
        randomInt++; //random number range is now the correct 1-100
        System.out.println("//for Pramod's eyes only: random int is " + randomInt);        
        System.out.println("Guess a secret number between 1 and 100.\nYou have 5 chances to get within 10!");
		Scanner input = new Scanner(System.in);

		while (guessCounter < 6) {
			System.out.print("\nEnter guess #" + guessCounter + ": ");
			guess = input.nextInt();
			checker = Math.abs(guess - randomInt);
			if (checker <= 10) {
				System.out.print("\nWinner! The secret number was " + randomInt + "!");
				guessCounter = 10;
			}
			else {
				guessCounter++;
			}
		}	
		
		if (guessCounter != 10) {
			System.out.print("\nSorry, better luck next time!");
		}
		
        input.close();
	}
}
