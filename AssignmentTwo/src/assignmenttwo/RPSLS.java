/**
 * Purpose: Chooses a random item and plays RPSLS with the user
 * Author: Ashley Kim 
 * Date: September 24, 2020 
 * Course: ICS4U1
 */

package assignmenttwo;

// Allows scanners, and allows the check for Exceptions with try and catch statements
import java.util.*;

public class RPSLS {

	public static void main(String[] args) {
		System.out.println("Welcome to <Rock, Paper, Scissors, Lizard, Spock> game!");
		boolean stop = false;
		// Variables to store the scores
		int compWin = 0;
		int playerWin = 0;
		int tie = 0;
		
		// Arrays to store the stats
		int[] compStat = new int[5];
		int[] playerStat = new int[5];
		
		// Generates a scanner for user input
		Scanner input = new Scanner(System.in);
		
		// Loops the following until the user quits the game
		while (!stop) {
			try {
				System.out.println(
						"Enter one of the following: " +
						"\n Rock- 0, Spock- 1, Paper- 2, Lizard- 3, Scissors- 4");
				int playerInt = input.nextInt();
				
				// Generates random number and selects the corresponding item
				int compInt = (int) (Math.random() * 5);
				
				// 2D string arrays of sayings that are assigned to variables and displayed to user
				String[][] items = { { " loves ", " is vaporized by ", " is covered by ", " crushes ", " crushes " },
						{ " vaporizes ", " loves ", " is disproved by ", " is poisoned by ", " smashes " },
						{ " covers ", " disproves ", " loves ", " is eaten by ", " is cut by " },
						{ " is crushed by ", " poisons ", " eats ", " loves ", " is decapitated by " },
						{ " are crushed by ", " are smashed by ", " cut ", " decapitate ", " love " },
						{ "rock", "spock", "paper", "lizard", "scissors" } };
				
				// Assigns the corresponding item from the 2D array above
				String playerStr = items[5][playerInt];
				String compStr = items[5][compInt];
				System.out.print("You played " + playerStr + "... The computer played " + compStr + "... ");
				
				// Displays the corresponding sayings
				System.out.print(playerStr + items[playerInt][compInt] + compStr + "!");

				/*
				 * Calculates and distinguishes the winner with the result If
				 * result = 0 = tie, 1,2 = computer's win, 3,4 = player's win
				 */
				int x = compInt - playerInt;
				int result = Math.floorMod(x, 5);
				switch (result) {
				case 0:
					System.out.println(" It's a tie!");
					tie += 1;
					break;
				case 1:
				case 2:
					System.out.println(" The computer wins!");
					compWin += 1;
					break;
				case 3:
				case 4:
					System.out.println(" You win!");
					playerWin += 1;
				}
				// The number of corresponding index is added up to keep track of stats
				compStat[compInt] += 1;
				playerStat[playerInt] += 1;
				
				// Displays the stat of the computer's and user's choices
				System.out.printf("%25s%-10s%-10s%-10s%-10s%-10s%n%-10s", 
								  " ", "Rock", "Spock", "Paper", "Lizard", "Scissors", "So far, you have played... ");
				System.out.printf("%-10s%-10s%-10s%-10s%-10s", 
								  playerStat[0], playerStat[1], playerStat[2], playerStat[3], playerStat[4]);
				System.out.printf("%n%-10s", "The computer has played... ");
				System.out.printf("%-10s%-10s%-10s%-10s%-10s", 
								  compStat[0], compStat[1], compStat[2], compStat[3], compStat[4]);
				
				// Displays the current score
				System.out.println("\nThe current score is... ");
				System.out.printf("%-1s%-9s%-2s%-8s%-4s%s%n%-5s%-5s%-5s%-5s%-5s%s%n",
								  " ", "Computer", ":", "Player", ":", "tie", " ", compWin, ":", playerWin, ":", tie);
				
				
				System.out.println("Would you like to play again? If yes, enter y. If no, enter n:");
				
				/* Loops when the input = "y", exits the loop when the input = "n";
				 * however, if the input is neither, it displays a string and is looped
				 */
				boolean error;
				do {
					String playerAns = input.nextLine();
					error = false;
					if (playerAns.equals("n")) {
						System.out.println("Goodbye!");
						input.close();
						// Exits the while loop
						stop = true;
					}
					if (!playerAns.equals("y") && !playerAns.equals("n")) {
						error = true;
						System.out.println("Please enter y or n only.");
					}
					else error = false;
				} while (error);
				
			  // When following exception occurs, displays the following string and gets input.
			} catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Please enter from one of the following integers only.");
				input.nextLine();
			}
		}
	}
}
