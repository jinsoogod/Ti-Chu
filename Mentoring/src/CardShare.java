
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
		// CardCase에서 만든 52장의 카드들을 유저1명당 1장씩 순차적으로 배분						
		while(true) {
			// 인덱스 0의 카드를 유저에게 추가하고 해당 카드를 리스트에서 삭제 - > 반복
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
