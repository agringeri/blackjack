package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Blackjack {

	// Player
	public static Player player = new Player();
	// Dealer
	public static Player dealer = new Player();

	public static void main(String[] args) {
		// Object for reading keyboard input
		Scanner keyboard = new Scanner (System.in);

		// keep asking until player quits
		while (true) {	
			System.out.println("(1) Start \n(2) Info \n(3) Quit");
			int menuChoice = keyboard.nextInt();

			if (menuChoice == 1) {
				game();
			} else if (menuChoice == 2) {
				printInfo();
			} else if (menuChoice == 3) {
				System.out.println("Exiting...");
				keyboard.close();
				return;
			} else {
				System.out.println("Input not valid. Please try again.");
			}
		}
	}

	// play the game
	public static void game() {
		// reset scores
		player.score = 0;
		dealer.score = 0;
		
		Scanner keyboard = new Scanner(System.in);
		Card[] cardsToAdd = new Card[52];
		int cardsDealt = 0;
		int playerHandSize = 0;
		int dealerHandSize = 0;

		// Add 4 Aces worth 11 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i-1] = new Card(11, i, 1);
		}

		// Add 4 Two's worth 2 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+3] = new Card(2, i, 2);
		}

		// Add 4 Three's worth 3 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+7] = new Card(3, i, 3);
		}

		// Add 4 Fours's worth 4 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+11] = new Card(4, i, 4);
		}

		// Add 4 Fives's worth 5 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+15] = new Card(5, i, 5);
		}

		// Add 4 Six's worth 6 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+19] = new Card(6, i, 6);
		}

		// Add 4 Seven's worth 7 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+23] = new Card(7, i, 7);
		}

		// Add 4 Eights's worth 8 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+27] = new Card(8, i, 8);
		}

		// Add 4 Nine's worth 9 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+31] = new Card(9, i, 9);
		}

		// Add 4 Ten's worth 10 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+35] = new Card(10, i, 10);
		}

		// Add 4 Jack's worth 10 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+39] = new Card(10, i, 11);
		}

		// Add 4 Queen's worth 10 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+43] = new Card(10, i, 12);
		}

		// Add 4 King's worth 10 each
		for (int i = 1; i <= 4; i++) {
			cardsToAdd[i+47] = new Card(10, i, 13);
		}

		// Shuffle the cards 
		shuffleCards(cardsToAdd);

		// Add the cards to our deck
		Deck deck = new Deck(cardsToAdd);

		// Add card to both player and dealers hands
		player.addCardToHand(deck.getCard(cardsDealt), playerHandSize);
		player.addValueToScore(deck.getCard(cardsDealt).getValue());
		System.out.println("You got a " 
				+ getNumberString(deck.getCard(cardsDealt).getNumber())
				+ " of " 
				+ getSuit(deck.getCard(cardsDealt).getSuit()));
		cardsDealt++;
		playerHandSize++;

		dealer.addCardToHand(deck.getCard(cardsDealt), dealerHandSize);
		dealer.addValueToScore(deck.getCard(cardsDealt).getValue());
		System.out.println("Dealer got a " 
				+ getNumberString(deck.getCard(cardsDealt).getNumber())
				+ " of " 
				+ getSuit(deck.getCard(cardsDealt).getSuit()));
		cardsDealt++;
		dealerHandSize++;

		// Add another card to both player and dealers hands
		player.addCardToHand(deck.getCard(cardsDealt), playerHandSize);
		player.addValueToScore(deck.getCard(cardsDealt).getValue());
		System.out.println("You got a " 
				+ getNumberString(deck.getCard(cardsDealt).getNumber())
				+ " of " 
				+ getSuit(deck.getCard(cardsDealt).getSuit()));
		cardsDealt++;
		playerHandSize++;

		dealer.addCardToHand(deck.getCard(cardsDealt), dealerHandSize);
		dealer.addValueToScore(deck.getCard(cardsDealt).getValue());
		System.out.println("Dealer got a " 
				+ getNumberString(deck.getCard(cardsDealt).getNumber())
				+ " of " 
				+ getSuit(deck.getCard(cardsDealt).getSuit()) + "\n");
		cardsDealt++;
		dealerHandSize++;

		System.out.println("Your current score is:      " + player.getScore());
		System.out.println("Dealer's current score is : " + dealer.getScore() + "\n");

		boolean standFlag = false;

		System.out.println("Would you like to hit or stand?");
		String choice = keyboard.nextLine();

		if (choice.equals("hit")) {
			standFlag = false;
		} else if (choice.equals("stand")) {
			standFlag = true;
		}

		while (standFlag == false) {

			// add a card to players hand
			player.addCardToHand(deck.getCard(cardsDealt), playerHandSize);
			player.addValueToScore(deck.getCard(cardsDealt).getValue());
			System.out.println("You got a " 
					+ getNumberString(deck.getCard(cardsDealt).getNumber())
					+ " of " 
					+ getSuit(deck.getCard(cardsDealt).getSuit()));
			System.out.println("Your current score is:      " + player.getScore());
			System.out.println("Dealer's current score is : " + dealer.getScore() + "\n");
			
			cardsDealt++;
			playerHandSize++;

			if (player.getScore() > 21) {
				System.out.println("Bust. Sorry, you lost!\n");
				// leave game
				return;
			}

			System.out.println("Would you like to hit or stand?");
			String choice2 = keyboard.nextLine();

			if (choice2.equals("hit")) {
				standFlag = false;
			} else if (choice2.equals("stand")) {
				standFlag = true;
			}
		}

		while (dealer.getScore() <= 16) {
			dealer.addCardToHand(deck.getCard(cardsDealt), dealerHandSize);
			dealer.addValueToScore(deck.getCard(cardsDealt).getValue());
			System.out.println("Dealer got a " 
					+ getNumberString(deck.getCard(cardsDealt).getNumber())
					+ " of " 
					+ getSuit(deck.getCard(cardsDealt).getSuit()));
			System.out.println("Your current score is:      " + player.getScore());
			System.out.println("Dealer's current score is : " + dealer.getScore() + "\n");
			cardsDealt++;
			dealerHandSize++;

			if ((dealer.getScore() == 21) && (player.getScore() == 21)) {
				System.out.println("You and the dealer have 21. Tie!\n");
				return;
			}

			if (dealer.getScore() > 21) {
				System.out.println("Dealer got over 21. You win!\n");
				return;
			}
		}

		if (player.getScore() > dealer.getScore()) {
			System.out.println("Congrats, you win!\n");
			printFinalScores();
			return;
		}

		if (dealer.getScore() > player.getScore()) {
			System.out.println("Sorry, you lost!\n");
			printFinalScores();
			return;
		}

		if (dealer.getScore() == player.getScore()) {
			System.out.println("It's a tie!\n");
			printFinalScores();
			return;
		}

		// game ended
		keyboard.close();
		return;

	}

	public static void shuffleCards(Card[] cards) {
		int index;
		Card temp;
		Random random = new Random();
		for (int i = cards.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}
	}

	public static String getSuit(int suit) {
		if (suit == 1) {
			return "Clubs";
		} else if (suit == 2) {
			return "Diamonds";
		} else if (suit == 3) {
			return "Hearts"; 
		} else if (suit == 4) {
			return "Spades";
		} else {
			return "";
		}
	}

	public static String getNumberString(int number) {
		if (number == 1) {
			return "Ace";
		} else if (number == 2) {
			return "Two";
		} else if (number == 3) {
			return "Three";
		} else if (number == 4) {
			return "Four";
		} else if (number == 5) {
			return "Five";
		} else if (number == 6) {
			return "Six";
		} else if (number == 7) {
			return "Seven";
		} else if (number == 8) {
			return "Eight";
		} else if (number == 9) {
			return "Nine";
		} else if (number == 10) {
			return "Ten";
		} else if (number == 11) {
			return "Jack";
		} else if (number == 12) {
			return "Queen";
		} else if (number == 13) {
			return "King";
		} else {
			return "";
		}
	}

	public static void printFinalScores() {
		System.out.println("Final Scores:");
		System.out.println("You: " + player.getScore());
		System.out.println("Dealer: " + dealer.getScore() + "\n");
	}

	public static void printInfo() {
		System.out.println("\n\nBlackjack, also known as twenty-one, is the most" +
				" widely played casino \nbanking game in the world. Blackjack is a" +
				" comparing card game between \na player and dealer, meaning players" +
				" compete against the dealer but not \nagainst other players. It is" +
				" played with one or more decks of 52 cards. \nThe objective of the game" +
				"is to beat the dealer in one of the following ways:" +"\n\nGet 21" +
				" points on the player's first two cards (called a \"blackjack\" or" +
				" \"natural\"), without a dealer blackjack \nReach a final score higher " +
				"than the dealer without exceeding 21; or \nLet the dealer draw additional " +
				"cards until his or her hand exceeds 21.\n");
	}
}
