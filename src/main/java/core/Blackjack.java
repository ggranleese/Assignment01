package core;

import java.io.InputStream;
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
		System.out.println(dealerVisible + "\nDealer Score: " + dealerScore);
		
	}
	
	public void playerDeal() {
		
		Card card = deck.dealCard();
		playerScore += card.getVal();
		if (!checkPlayerBust()) {
			System.out.println("\n" + card);
			System.out.println("PLAYER TOTAL: " + playerScore);
		}else {
			checkWinner();
		}
	}
	
	public void dealerDeal() {
		Card card = deck.dealCard();
		dealerScore += card.getVal();
		if (!checkDealerBust()) {
			System.out.println("\n" + card);
			System.out.println("Dealer TOTAL: " + dealerScore);
		}else {
			checkWinner();
		}
	}
	
	private boolean checkPlayerBust() {
		if(playerScore >21) {
			return true;
		}else {
			return false;
		}
		
	}
	
	private boolean checkDealerBust() {
		if(dealerScore >21) {
			return true;
		}else {
			return false;
		}
	}

	public void playerStands() {
		
		dealerScore += dealerHidden.getVal();
		while(dealerScore <=16) {
			dealerDeal();
		}
		checkWinner();
	}
	

	public String checkWinner() {
		
		if(playerScore > 21) {
			return("\n\n PLAYER BUSTS, DEALER WINS");
		}else if(dealerScore > 21) {
			return("\n\n Dealer BUSTS, PLAYER WINS");
		}
		
		if(playerScore > dealerScore) {
			return("\n\n PLAYER WINS");
		}else if(dealerScore > playerScore) {
			return("\n\n PLAYER LOSES");
		}else {
			return("\n\n PUSH");
		}
	}
	
	public static void main(String args[]) {
		System.out.println("BLACKJACK");
		while(true){
		
		}

	}

}
