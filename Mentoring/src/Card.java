

// ī�带 ����� ���� ��ü�� �����Ѵ�.

public class Card {
	private String card;
	public static String[] grim = {"��","��","��","��"};
	public static String[] num = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	
	public Card() {
		init();
	}


	private void init() {
		int g = (int)(Math.random()*grim.length);
		int n = (int)(Math.random()*num.length);
		
		
		// ī�忡 �׸��� �ѹ��� �ִ´�.
		card = grim[g]+num[n];
	}
	
	
	public String getCard() {
		return card;
	}
	
	
	
	
	// ī���� ��ü�ȿ� �ִ� ���� ���ٸ�, �� ī����� ���� ���� ��ü��� ���ִ� ������ �������̵�
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
