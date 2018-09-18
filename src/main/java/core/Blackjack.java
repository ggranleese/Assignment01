package core;

import java.util.Scanner;

public class Blackjack {
	Deck deck;
	int playerScore;
	int dealerScore;
	Card dealerVisible;
	Card dealerHidden;
	
	public Blackjack() {
		deck = new Deck();
		deck.initDeck();
		playerScore = 0;
		dealerScore = 0;
	}
	
	public Deck getDeck() {
		return deck; 
	}
	
	public void firstDeal() {
		deck.shuffle();
		for(int p=0; p<2; p++) {
			Card card = deck.dealCard();
			playerScore += card.getVal() ;
			System.out.println(card);
		}
		System.out.println("PLAYER TOTAL: " + playerScore);
		
		dealerVisible = deck.dealCard();
		dealerHidden = deck.dealCard();
		dealerScore += dealerVisible.getVal();
		System.out.println("\n" + dealerVisible + "\nDealer Showing: " + dealerScore);
		
	}
	
	public void playerDeal() {
		
		Card card = deck.dealCard();
		playerScore += card.getVal();
		if (playerScore < 21) {
			System.out.println("\n" + card);
			System.out.println("PLAYER TOTAL: " + playerScore);
		}else if(playerScore == 21) {
			System.out.println("\n" + card);
			System.out.println("PLAYER TOTAL: " + playerScore);
			System.out.println("BLACJKACK");
			checkWinner();
		}else {
			System.out.println("\n" + card);
			System.out.println("PLAYER TOTAL: " + playerScore);
			checkWinner();
		}
	}
	
	public void dealerDeal() {
		while(dealerScore <= 21) {
			Card card = deck.dealCard();
			dealerScore += card.getVal();
			
			if(dealerScore > 21) {
				System.out.println("\n" + card);
				System.out.println("Dealer TOTAL: " + dealerScore);
				break;
			}else {
				System.out.println("\n" + card);
				System.out.println("Dealer TOTAL: " + dealerScore);
			}
			
		}
		checkWinner();	
	}
	
	public void playerStands() {
		
		dealerScore += dealerHidden.getVal();
		while(dealerScore <=16) {
			dealerDeal();
		}
	}
	

	public void checkWinner() {
		
		if(playerScore > 21) {
			System.out.println("\n\n PLAYER BUSTS, DEALER WINS");
			
		}else if(dealerScore > 21) {
			System.out.println("\n\n Dealer BUSTS, PLAYER WINS");
			
		}else if(playerScore > dealerScore) {
			System.out.println("\n\n PLAYER WINS");
			
		}else if(dealerScore > playerScore) {
			System.out.println("\n\n PLAYER LOSES");
			
		}else if(playerScore == 21 && dealerScore != 21){
			System.out.println("\n\n PLAYER WINS");
		}else {
			System.out.println("\n\n PUSH");
		}
			
	}
	
	public static void main(String args[]) {
		System.out.println("BLACKJACK \n\n");
		while(true){
			Blackjack game = new Blackjack();
			game.firstDeal();
			String cont = "c";
			
			while(true) {
				System.out.println("(H)it or (S)tand? \n $:");
				Scanner player = new Scanner(System.in);
				if (player.hasNextLine()){
					cont = player.nextLine();
				}
				
				if(cont.equals("h") || cont.equals("H")) {
					game.playerDeal();
					
				}else if (cont.equals("s") || cont.equals("S")){
					game.playerStands();
					break;
				}else {
					break;
				}
			}
			
			System.out.println("Press any key to play again or (Q) to (q)uit \n$:");
			String re = "";
			Scanner restart = new Scanner(System.in);
			if(restart.hasNextLine()) {
				re = restart.nextLine();
			}
			if (re.equals("Q") || re.equals("q")) {
				break;
			}else {
				System.out.println("\n\n\n");
			}
			
	
		}
	}

}
