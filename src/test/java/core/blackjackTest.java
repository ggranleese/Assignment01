package core;

import junit.framework.TestCase;

public class blackjackTest extends TestCase{
	
	public void testGameStart() {
		Blackjack game = new Blackjack();
		assertEquals(52, game.getDeck().numCards());
	}
	
	public void testCardsDelt() {
		Blackjack game = new Blackjack();
		game.deal();
		assertTrue(game.getPlayerScore() !=0 && game.getDealerScore() !=0);
	}
	
	public void testDealerHit() {
		Blackjack game = new Blackjack();
		game.deal();
		game.playerStands();
		
		assertTrue(game.getDealerScore() > 16);
		
	}
	
	public void testWinner() {
		Blackjack game = new Blackjack();
		game.deal();
		game.playerStands();
		
		if(game.getPlayerScore() > game.getDealerScore() && game.getPlayerScore()< 21) {
			assertEquals(true, game.playerWins());
		}else {
			assertEquals(true, game.dealerWins());
		}
	}
	

}
