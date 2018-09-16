package core;

import junit.framework.TestCase;

public class cardTest extends TestCase {

	public void testFaceVal() {
		Card jack = new Card(h, 11, true);
		Card queen = new Card(h, 12, true);
		Card king = new Card(h, 13, true);
		
		assertEquals(10, jack.getVal());
		assertEquals(10, queen.getVal());
		assertEquals(10, king.getVal());
	}
	
	public void testToString() {
		Card jack = new Card(1, 11, true);
		Card queen = new Card(1, 12, true);
		Card king = new Card(1, 13, true);
		Card ace = new Card(1, 1, true);
		
		assertEquals("HJ", jack.toString());
		assertEquals("HQ", queen.toString());
		assertEquals("HK", king.toString());
		assertEquals("HA", ace.toString());
	}
	
	public void testAceHigh() {
		Card ace = new Card(1, 1, true);
		
		assertEquals(11, ace.getVal());
	}
	
	public void testAceLow() {
		Card ace = new Card(1, 1, false);
		
		assertEquals(1, ace.getVal());
	}
	
}
