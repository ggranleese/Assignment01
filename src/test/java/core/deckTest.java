package core;

import junit.framework.TestCase;

public class deckTest extends TestCase {

	public void testDeckReset() {
		Deck deck = new Deck();
		assertEquals(52, deck.getSize());
	}

	public void testRemoveCard() {
		Deck deck = new Deck();
		deck.removeCard();
		
		assertEquals(51, deck.getSize());
	}
		
}
