
import java.util.ArrayList;

public class CardShare {
	int cardCount = 0;
	ArrayList<Card> list = null;
	UserSet us = null;
	int cardNum = 0;

	public CardShare(ArrayList<Card> list,UserSet us, int cardNum) {
		this.list = list;
		this.us = us;
		this.cardNum = cardNum;
	}
	
	public void shareToUser() {
		// CardCase���� ���� 52���� ī����� ����1��� 1�徿 ���������� ���						
		while(true) {
			// �ε��� 0�� ī�带 �������� �߰��ϰ� �ش� ī�带 ����Ʈ���� ���� - > �ݺ�
			us.user1.add(cardCount,list.get(0));
			list.remove(0);
			us.user2.add(cardCount,list.get(0));
			list.remove(0);
			us.user3.add(cardCount,list.get(0));
			list.remove(0);
			us.user4.add(cardCount,list.get(0));
			list.remove(0);
			cardCount++;
			if (cardCount == cardNum)		
				break;
		}
	}
}
