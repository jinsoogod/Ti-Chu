

// 카드를 만들기 위한 객체를 생성한다.

public class Card {
	private String card;
	public static String[] grim = {"♠","◇","♡","♣"};
	public static String[] num = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	
	public Card() {
		init();
	}


	private void init() {
		int g = (int)(Math.random()*grim.length);
		int n = (int)(Math.random()*num.length);
		
		
		// 카드에 그림과 넘버를 넣는다.
		card = grim[g]+num[n];
	}
	
	
	public String getCard() {
		return card;
	}
	
	
	
	
	// 카드라는 객체안에 있는 값이 같다면, 그 카드들은 서로 같은 객체라고 해주는 이퀄스 오버라이딩
	@Override
	public boolean equals(Object obj) {
		boolean isS = false;
		Card cd = (Card)obj;
		
		if (card.equals(cd.getCard())) {
			isS = true;
		}
		
		return isS;
	}
	
	@Override
	public int hashCode() {
		
		return hashCode()+137;
	}
}
