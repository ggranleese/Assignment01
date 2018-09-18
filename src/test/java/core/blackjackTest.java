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
	
	public void testWinner() {
		Blackjack game = new Blackjack();
		game.firstDeal();
		game.playerStands();
		
		if(game.playerScore > game.dealerScore && game.playerScore < 21 && game.dealerScore < 21 ) {
			assertEquals("\n\n PLAYER WINS", game.checkWinner());
		}else {
			assertEquals("\n\n PLAYER WINS", game.checkWinner());
		}
	}
	

}
