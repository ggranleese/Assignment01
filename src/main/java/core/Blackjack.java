package core;

import java.io.File;
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
	
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		System.out.println("BLACKJACK \n\n");
		while(true){
			
			String fc = "";
			String cont = "";
			System.out.println("Would you like to use (F)ile or (C)oncole input: ");
			
			Scanner choice = new Scanner(System.in);
			if(choice.hasNext()) {
				fc = choice.nextLine();
			}
			
			if(fc.equals("f") || fc.equals("F")) {
				//FILE GAMEPLAY
				Blackjack game = new Blackjack();
				System.out.println("Please enter the file you wish to enter: ");
				Scanner filePathInput = new Scanner (System.in);
				Scanner file = null;
				String filePath = "";
				String readFile = "";
				String[] cards;
				boolean playerTurn = true;
				
				if(filePathInput.hasNext()) {
					filePath = filePathInput.nextLine();
				}
				
				filePath = "src/main/resources/core/test.txt";
				
				
				
				try {
					file = new Scanner(new File(filePath));
				}catch(Exception e) {
					System.out.println("ERROR: FILE NOT FOUND");
				}
				
				while(file.hasNext()) {
					readFile += (file.next() + " ");
				}
				cards = readFile.split(" ");
				
				
				for(int i=0; i<cards.length; i++){
					
					
					if(game.playerScore <21) {
						
						if(i>2) {
							System.out.println("PLAYER SCORE: " + game.playerScore);
							System.out.println("DEALER SCORE: " + game.dealerScore);
							System.out.println("\n");
							System.out.println("(H)it or (S)tand? \n $:");
							Scanner player = new Scanner(System.in);
							if(player.hasNext()) {
								cont = player.nextLine();
							}
							
							if(cont.equals("h") || cont.equals("H")) {
								playerTurn = true;
							}else if(cont.equals("s") || cont.equals("S")) {
								playerTurn = false;
							}
						}
						
						
						
						
						if(cards[i].endsWith("J") || cards[i].endsWith("Q") || cards[i].endsWith("K") || cards[i].endsWith("10")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 10;
							}else {
								game.dealerScore = game.dealerScore + 10;
							}
							
							
						}else if (cards[i].endsWith("2")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 2;
							}else {
								game.dealerScore = game.dealerScore + 2;
							}
							
						}else if (cards[i].endsWith("3")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 3;
							}else {
								game.dealerScore = game.dealerScore + 3;
							}
							
						}else if (cards[i].endsWith("4")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 4;
							}else {
								game.dealerScore = game.dealerScore + 4;
							}
							
						}else if (cards[i].endsWith("5")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 5;
							}else {
								game.dealerScore = game.dealerScore + 5;
							}
							
						}else if (cards[i].endsWith("6")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 6;
							}else {
								game.dealerScore = game.dealerScore + 6;
							}
							
						}else if (cards[i].endsWith("7")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 7;
							}else {
								game.dealerScore = game.dealerScore + 7;
							}
							
						}else if (cards[i].endsWith("8")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 8;
							}else {
								game.dealerScore = game.dealerScore + 8;
							}
							
						}else if (cards[i].endsWith("9")){
							
							if(playerTurn) {
								game.playerScore = game.playerScore + 9;
							}else {
								game.dealerScore = game.dealerScore + 9;
							}

						}
						
						
					}else {
						game.checkWinner();
						break;
					}
					
					if(i==1) {
						playerTurn = false;
					}
					
					
					
				}
				game.checkWinner();
				
	
			}else if(fc.equals("c") || fc.equals("C")) {
				//CONSOLE GAMEPLAY
				Blackjack game = new Blackjack();
				game.firstDeal();
				
				while(true) {
					if(game.playerScore <21) {
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
					}else {
						game.playerStands();
						break;
					}
					
				}
				
			}else {
				System.out.println("\n\n\nPress any key to play again or (Q) to (q)uit \n$:");
				String re = "";
				Scanner restart = new Scanner(System.in);
				if(restart.hasNextLine()) {
					re = restart.nextLine();
				}
				if (re.equals("Q") || re.equals("q")) {
					System.out.println("THANK YOU ");
					break;
				}else {
					System.out.println("\n\n\n");
				}	
			}
		}
	}

}
