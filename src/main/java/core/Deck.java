package core;

//import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int numCards;
	
	public Deck() {
		
		cards = new Card[52];
		numCards = 52;
		initDeck();
	}
	
	
	public void initDeck() {
		
		int deckPos = 0;
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=13; j++) {
				
				cards[deckPos] = new Card(i,j,false);
				deckPos ++;
			}
		}	
	}
	
	public int getSize() {
		return numCards;
	}
	
	public void removeCard() {
		if(numCards >0){
			for(int i=0; i<cards.length-1; i++) {
				cards[i] = cards[i+1];
			}
			numCards--; 
		}
	}

}
