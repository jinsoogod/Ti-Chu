
import java.util.ArrayList;

//�������� ī�带 �ϳ��� ����� ������ �� ī����� ��� ���� ���̽��� ����

/* ���δٸ� 13 * 4 = 52 ���� ī�带 ����.
 *   ��---- �߿�
 * */

public class CardCase {
	private ArrayList<Card> cards;
	
	public CardCase() {
		cards = new ArrayList<Card>();
		shuffle();
	}

	private void shuffle() {
		int count = 0;
		
		while(true) {
			Card cd = new Card();			
			if (!cards.contains(cd)) {		// ���� �ٸ��� cards�� �ְԲ�
				cards.add(cd);
				count++;
			}
			
			if(count == 52) {		// ���� �־�����
				break;
			}
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
}
