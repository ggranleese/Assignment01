package core;

import junit.framework.TestCase;

public class blackjackTest extends TestCase{
	
	public void testGameStart() {
		Blackjack game = new Blackjack();
		assertEquals(52, game.getDeck().getSize());
	}
	
	public void testCardsDelt() {
		Blackjack game = new Blackjack();
		game.firstDeal();
		assertTrue(game.playerScore !=0 && game.dealerScore !=0);
	}
	
	public void testDealerHit() {
		Blackjack game = new Blackjack();
		game.firstDeal();
		game.playerStands();
		
		assertTrue(game.dealerScore > 16);
		
	}
	
	public void testPlayerHit() {
		Blackjack game = new Blackjack();
		game.firstDeal();
		int firstScore = game.playerScore;
		game.playerDeal();
		int secondScore = game.playerScore;
		assertTrue(firstScore < secondScore);
	}
	
	public void testPlayerHitRepeat() {
		Blackjack game = new Blackjack();
		game.firstDeal();
		int firstScore = game.playerScore;
		game.playerDeal();
		int secondScore = game.playerScore;
		game.playerDeal();
		int thirdScore = game.playerScore;
		assertTrue(firstScore < secondScore);
		assertTrue(secondScore < thirdScore);
		
	}


}
