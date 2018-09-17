package core;

import junit.framework.TestCase;

public class deckTest extends TestCase {

	public void testDeckReset() {
		Deck deck = new Deck();
		deck.initDeck();
		assertEquals(52, deck.getSize());
	}

	public void testRemoveCard() {
		Deck deck = new Deck();
		deck.initDeck();
		deck.removeCard(0);
		
		assertEquals(51, deck.getSize());
	}

//	public void testDealCard() {
//		Deck deck = new Deck();
//		deck.dealCard();
//		
//		assertEquals("H2", deck.dealCard());
//		
//	}
		
}
