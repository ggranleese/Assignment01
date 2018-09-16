package core;

import junit.framework.TestCase;

public class deckTest extends TestCase {

	public void deckResetTest() {
		Deck deck = new Deck();
		
		assertEquals(52, deck.getSize());
	}

	public void removeCardTest() {
		Deck deck = new Deck();
		deck.removeCard(0);
		
		assertEquals(51, deck.getSize());
	}
		
}
