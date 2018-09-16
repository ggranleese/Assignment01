package core;

public class Card {
	private int suit;
	private int type;
	private boolean acesHigh;

	public Card(int s, int t, boolean a) {
		
		this.suit = s;
		this.type = t;
		this.acesHigh = a;
	}
	
	public int getVal() {
		
		if(acesHigh && type == 1) {
			return 11;
			
		}else if(!acesHigh && type == 1){
			return 1;
			
		}else if(type >10) {
			return 10;
			
		}else {
			return type;
		}
	}
	
	public String toString() {
		
		if(type<=10 && type>1) {
			
			if(suit == 1) {
				return("H"+ type);
				
			}else if(suit == 2) {
				return("D"+ type);
				
			}else if (suit == 3) {
				return("S" + type);
				
			}else {
				return("C" + type);
			}
			
		}else if(type == 11) {
			
			if(suit == 1) {
				return("HJ");
				
			}else if(suit == 2) {
				return("DJ");
				
			}else if (suit == 3) {
				return("SJ");
				
			}else {
				return("CJ");
			}	
			
		}else if(type == 12) {
			
			if(suit == 1) {
				return("HQ");
				
			}else if(suit == 2) {
				return("DQ");
				
			}else if (suit == 3) {
				return("SQ");
				
			}else {
				return("CQ");
			}	
			
		}else if(type == 13) {
			
			if(suit == 1) {
				return("HK");
				
			}else if(suit == 2) {
				return("DK");
				
			}else if (suit == 3) {
				return("SK");
				
			}else {
				return("CK");
			}	
			
		}else{
			
			if(suit == 1) {
				return("HA");
				
			}else if(suit == 2) {
				return("DA");
				
			}else if (suit == 3) {
				return("SA");
				
			}else {
				return("CA");
			}	
		} 

	}
	
	public String getCard() {
		return this.toString();
	}
}
